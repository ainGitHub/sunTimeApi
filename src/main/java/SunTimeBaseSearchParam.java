import java.time.LocalDate;

public class SunTimeBaseSearchParam {
    private Double latitude;
    private Double longitude;
    private LocalDate date;

    public SunTimeBaseSearchParam() {
    }

    public SunTimeBaseSearchParam(LocalDate date, Double latitude, Double longitude) {
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public SunTimeBaseSearchParam(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
