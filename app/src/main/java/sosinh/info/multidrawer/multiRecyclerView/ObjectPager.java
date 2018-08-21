package sosinh.info.multidrawer.multiRecyclerView;

import java.util.List;

/**
 * Created by Chau Huynh on 2/23/2018.
 */

public class ObjectPager {
    private String section;
    List<Pager> pager;

    public ObjectPager() {
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Pager> getPager() {
        return pager;
    }

    public void setPager(List<Pager> pager) {
        this.pager = pager;
    }
}
