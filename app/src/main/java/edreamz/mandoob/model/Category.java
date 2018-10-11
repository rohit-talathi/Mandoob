package edreamz.mandoob.model;

public class Category {

    private String id;
    private String name;
    private String description;
    private String image;
    private int is_subcategory;
    private String info;
    private String category_id;
    private String is_subofsubcategory;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getIs_subofsubcategory() {
        return is_subofsubcategory;
    }

    public void setIs_subofsubcategory(String is_subofsubcategory) {
        this.is_subofsubcategory = is_subofsubcategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIs_subcategory() {
        return is_subcategory;
    }

    public void setIs_subcategory(int is_subcategory) {
        this.is_subcategory = is_subcategory;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
