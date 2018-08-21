package sosinh.info.multidrawer.multiRecyclerView;

/**
 * Created by Chau Huynh on 2/22/2018.
 */

public class Vertical {
    private String title;
    private String image;
    private String description;
    private String price;
    private String discount;

    public Vertical(String title, String image, String description, String price, String discount) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.price = price;
        this.discount = discount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
