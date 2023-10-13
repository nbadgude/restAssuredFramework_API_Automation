package pojo;

public class Pojo_products {
    private String item_description;
    private String catagory;
    private String brand;
    private String store_name;
    private String store_id;
    private String item_id;
    private int Stock;

    @Override
    public String toString() {
        return "Pojo_products{" +
                "item_description='" + item_description + '\'' +
                ", catagory='" + catagory + '\'' +
                ", brand='" + brand + '\'' +
                ", store_name='" + store_name + '\'' +
                ", store_id='" + store_id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", Stock=" + Stock +
                '}';
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}
