package sosinh.info.multidrawer.multiRecyclerView;

import java.util.List;

/**
 * Created by Chau Huynh on 2/22/2018.
 */

public class ObjectHorizontal {
    private String section;
    private String number;
    private List<Horizontal> horizontal;

    public ObjectHorizontal() {
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Horizontal> getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(List<Horizontal> horizontal) {
        this.horizontal = horizontal;
    }
}
