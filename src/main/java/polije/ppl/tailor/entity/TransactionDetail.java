package polije.ppl.tailor.entity;

import polije.ppl.tailor.entity.Package;

public class TransactionDetail implements EntityInterface {
    public static String tableName = "transaction_details";

    private int id, qty, price;
    private Package pkg;
    private Transaction transaction;
    private String clothName;

    public TransactionDetail() { }

    public TransactionDetail(int qty, int price, Package pkg, Transaction transaction, String clothName) {
        this.qty = qty;
        this.price = price;
        this.pkg = pkg;
        this.transaction = transaction;
        this.clothName = clothName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
