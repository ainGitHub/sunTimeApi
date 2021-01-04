import java.time.LocalDate;
import java.time.LocalTime;

/**
 * SunTime
 */
public class SunTime {
    /**
     * from search params
     */
    private LocalDate date;

    private LocalTime sunrise;
    private LocalTime sunset;
    private LocalTime solarNoon;
    private Integer dayLength;
    private LocalTime civilTwilightBegin;
    private LocalTime civilTwilightEnd;
    private LocalTime nauticalTwilightBegin;
    private LocalTime nauticalTwilightEnd;
    private LocalTime astronomicalTwilightBegin;
    private LocalTime astronomicalTwilightEnd;

    /**
     * @return suntime date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date suntime date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return time when sun rise
     */
    public LocalTime getSunrise() {
        return sunrise;
    }

    /**
     * @param sunrise time when sun rise
     */
    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * @return time when sun set
     */
    public LocalTime getSunset() {
        return sunset;
    }

    /**
     * @param sunset time when sun set
     */
    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    /**
     * @return time when solar noon
     */
    public LocalTime getSolarNoon() {
        return solarNoon;
    }

    /**
     * @param solarNoon time when solar noon
     */
    public void setSolarNoon(LocalTime solarNoon) {
        this.solarNoon = solarNoon;
    }

    /**
     * @return day length in seconds
     */
    public Integer getDayLength() {
        return dayLength;
    }

    /**
     * @param dayLength day length in seconds
     */
    public void setDayLength(Integer dayLength) {
        this.dayLength = dayLength;
    }

    /**
     * @return civil twilight begin time
     */
    public LocalTime getCivilTwilightBegin() {
        return civilTwilightBegin;
    }

    /**
     * @param civilTwilightBegin civil twilight begin time
     */
    public void setCivilTwilightBegin(LocalTime civilTwilightBegin) {
        this.civilTwilightBegin = civilTwilightBegin;
    }

    /**
     * @return civil twilight end time
     */
    public LocalTime getCivilTwilightEnd() {
        return civilTwilightEnd;
    }

    /**
     * @param civilTwilightEnd civil twilight end time
     */
    public void setCivilTwilightEnd(LocalTime civilTwilightEnd) {
        this.civilTwilightEnd = civilTwilightEnd;
    }

    /**
     * @return nautical twilight begin time
     */
    public LocalTime getNauticalTwilightBegin() {
        return nauticalTwilightBegin;
    }

    /**
     * @param nauticalTwilightBegin nautical twilight begin time
     */
    public void setNauticalTwilightBegin(LocalTime nauticalTwilightBegin) {
        this.nauticalTwilightBegin = nauticalTwilightBegin;
    }

    /**
     * @return nautical twilight end time
     */
    public LocalTime getNauticalTwilightEnd() {
        return nauticalTwilightEnd;
    }

    /**
     * @param nauticalTwilightEnd nautical twilight end time
     */
    public void setNauticalTwilightEnd(LocalTime nauticalTwilightEnd) {
        this.nauticalTwilightEnd = nauticalTwilightEnd;
    }

    /**
     * @return astronomical twilight begin time
     */
    public LocalTime getAstronomicalTwilightBegin() {
        return astronomicalTwilightBegin;
    }

    /**
     * @param astronomicalTwilightBegin astronomical twilight begin time
     */
    public void setAstronomicalTwilightBegin(LocalTime astronomicalTwilightBegin) {
        this.astronomicalTwilightBegin = astronomicalTwilightBegin;
    }

    /**
     * @return astronomical twilight end time
     */
    public LocalTime getAstronomicalTwilightEnd() {
        return astronomicalTwilightEnd;
    }

    /**
     * @param astronomicalTwilightEnd astronomical twilight end time
     */
    public void setAstronomicalTwilightEnd(LocalTime astronomicalTwilightEnd) {
        this.astronomicalTwilightEnd = astronomicalTwilightEnd;
    }

    @Override
    public String toString() {
        return "SunTime{" +
                "date=" + date +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
