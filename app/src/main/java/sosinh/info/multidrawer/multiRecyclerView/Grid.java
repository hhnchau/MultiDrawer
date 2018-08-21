package sosinh.info.multidrawer.multiRecyclerView;

/**
 * Created by Chau Huynh on 2/22/2018.
 */

public class Grid {
    private String title;
    private String image;

    public Grid(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
