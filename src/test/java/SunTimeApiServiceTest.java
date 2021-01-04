import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SunTimeApiServiceTest {

    private static final Double testLatitude = 36.7201600;
    private static final Double testLongitude = -4.4203400;

    @Test
    public void loadOneSunTimeTest() {
        SunTimeApiService sunTimeApiService = new SunTimeApiServiceImpl();
        SunTimeSearchParam searchParam = new SunTimeSearchParam(testLatitude, testLongitude);
        searchParam.getDates().add(LocalDate.of(2021, 1, 1));
        List<SunTime> sunTimes = sunTimeApiService.loadSunTimes(searchParam);
        Assert.assertEquals(sunTimes.size(), 1);
    }

    @Test
    public void loadWithNullLocationTest() {
        SunTimeApiService sunTimeApiService = new SunTimeApiServiceImpl();
        SunTimeSearchParam searchParam = new SunTimeSearchParam();
        searchParam.getDates().add(LocalDate.of(2021, 1, 1));

        Assert.assertThrows(IllegalArgumentException.class, () -> sunTimeApiService.loadSunTimes(searchParam));
        searchParam.setLatitude(testLatitude);
        Assert.assertThrows(IllegalArgumentException.class, () -> sunTimeApiService.loadSunTimes(searchParam));
    }

    @Test
    public void loadWithEmptyDatesTest() {
        SunTimeApiService sunTimeApiService = new SunTimeApiServiceImpl();
        SunTimeSearchParam searchParam = new SunTimeSearchParam(testLatitude, testLongitude);

        List<SunTime> sunTimes = sunTimeApiService.loadSunTimes(searchParam);
        Assert.assertEquals(sunTimes.size(), 0);
    }

    @Test
    public void loadMultipleSunTimesTest() {
        SunTimeApiService sunTimeApiService = new SunTimeApiServiceImpl();
        SunTimeSearchParam searchParam = new SunTimeSearchParam(testLatitude, testLongitude);
        LocalDate now = LocalDate.now();
        searchParam.setDates(IntStream.range(0, 10).mapToObj(i -> now.plusDays(1))
                .collect(Collectors.toList()));

        List<SunTime> sunTimes = sunTimeApiService.loadSunTimes(searchParam);
        Assert.assertEquals(sunTimes.size(), 10);
    }
}
