package polije.ppl.tailor.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionDetail implements Entity {
    public final static String tableName = "transaction_details";

    private Integer id;

    @NotNull(message = "Jumlah harus diisi")
    @Min(1)
    private int qty;

    @NotNull(message = "Harga harus diisi")
    @Min(1)
    private int price;

    private Package pkg;
    private Transaction transaction;

    @NotBlank(message = "Nama pakaian harus diisi")
    private String clothName;

    public TransactionDetail() { }

    public TransactionDetail(int qty, int price, Package pkg, Transaction transaction, String clothName) {
        this.qty = qty;
        this.price = price;
        this.pkg = pkg;
        this.transaction = transaction;
        this.clothName = clothName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPackage(Package pkg) {
        this.pkg = pkg;
    }

    public Package getPackage() {
        return pkg;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClothName() {
        return clothName;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }
}
