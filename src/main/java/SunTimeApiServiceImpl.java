import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class SunTimeApiServiceImpl implements SunTimeApiService {
    private static final String path = "https://api.sunrise-sunset.org/json?";

    @Override
    public List<SunTime> loadSunTimes(SunTimeSearchParam searchParam) {
        if (searchParam.getLatitude() == null || searchParam.getLongitude() == null) {
            throw new IllegalArgumentException("Locations must be not null");
        }

        if (searchParam.getDates().isEmpty()) {
            return Collections.emptyList();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            return loadSunTimeList(searchParam, executorService);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong", e);
        }
    }

    private List<SunTime> loadSunTimeList(SunTimeSearchParam searchParam, ExecutorService executorService)
            throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch = new CountDownLatch(searchParam.getDates().size());
        List<Callable<SunTime>> loaders = searchParam.getDates().stream()
                .map(date -> new SunTimeBaseSearchParam(date, searchParam.getLatitude(), searchParam.getLongitude()))
                .map(param -> new SunTimeLoader(param, countDownLatch))
                .collect(Collectors.toList());

        List<Future<SunTime>> futureList = executorService.invokeAll(loaders);
        executorService.shutdown();
        countDownLatch.await();

        List<SunTime> list = new ArrayList<>();
        for (Future<SunTime> sunTimeFuture : futureList) {
            list.add(sunTimeFuture.get());
        }
        return list;
    }

    private static class SunTimeLoader implements Callable<SunTime> {
        private final SunTimeBaseSearchParam baseSearchParam;
        private final CountDownLatch countDownLatch;
        private final ObjectMapper objectMapper;

        public SunTimeLoader(SunTimeBaseSearchParam baseSearchParam, CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            this.baseSearchParam = baseSearchParam;
            this.objectMapper = new ObjectMapper();
            this.objectMapper.registerModule(
                    new JavaTimeModule()
                            .addDeserializer(LocalTime.class,
                                    new LocalTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME)));
            this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        }

        @Override
        public SunTime call() throws Exception {
            SunTime result = loadSunTime();
            result.setDate(baseSearchParam.getDate());
            countDownLatch.countDown();
            return result;
        }

        private SunTime loadSunTime() throws IOException {
            URL url = new URL(path +
                    String.format("lat=%f&lng=%f&date=%s&formatted=0",
                            baseSearchParam.getLatitude(),
                            baseSearchParam.getLongitude(),
                            baseSearchParam.getDate().toString()));
            JsonNode parent = objectMapper.readTree(url);
            return objectMapper.treeToValue(parent.get("results"), SunTime.class);
        }
    }
}
