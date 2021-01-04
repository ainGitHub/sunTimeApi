import java.util.List;

/**
 * Sunrise-Sunset is a free online tool that provides users information about day length, twilight,
 * sunrise and sunset times for any location of the world
 */
public interface SunTimeApiService {

    /**
     * Provides sunset and sunrise times for a given search param
     * @param searchParam - search parameters
     * @return list of sunTimes for searchParam
     */
    List<SunTime> loadSunTimes(SunTimeSearchParam searchParam);
}
