package sosinh.info.multidrawer.multiRecyclerView;

import java.util.List;

/**
 * Created by Chau Huynh on 2/22/2018.
 */

public class ObjectGrid {
    private String section;
    private List<Grid> grid;

    public ObjectGrid() {
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Grid> getGrid() {
        return grid;
    }

    public void setGrid(List<Grid> grid) {
        this.grid = grid;
    }
}
