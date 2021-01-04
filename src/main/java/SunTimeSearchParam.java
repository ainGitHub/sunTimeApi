import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Search params
 */
public class SunTimeSearchParam extends SunTimeBaseSearchParam {
    private List<LocalDate> dates = new ArrayList<>();

    public SunTimeSearchParam() {
    }

    public SunTimeSearchParam(Double latitude, Double longitude) {
        super(latitude, longitude);
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        if (dates == null) {
            this.dates.clear();
            return;
        }
        this.dates = dates;
    }
}
