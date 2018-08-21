package sosinh.info.multidrawer.multiRecyclerView;

import java.util.List;

/**
 * Created by Chau Huynh on 2/22/2018.
 */

public class ObjectVertical {
    private String section;
    private String time;
    private List<Vertical> vertical;

    public ObjectVertical() {
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Vertical> getVertical() {
        return vertical;
    }

    public void setVertical(List<Vertical> vertical) {
        this.vertical = vertical;
    }
}
