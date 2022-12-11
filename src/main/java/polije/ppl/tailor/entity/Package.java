package polije.ppl.tailor.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Package implements Entity {
    public final static String tableName = "packages";

    private int id;

    @NotNull(message="Harga harus diisi")
    private int price;

    @NotBlank(message="Tipe pakaian harus diisi")
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
