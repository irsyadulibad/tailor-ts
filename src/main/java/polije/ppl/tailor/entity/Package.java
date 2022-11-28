package polije.ppl.tailor.entity;

public class Package implements Entity {
    public final static String tableName = "packages";

    private int id, price;
    private String name;

    public Package() {};

    public Package(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
