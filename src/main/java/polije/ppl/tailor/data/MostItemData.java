package polije.ppl.tailor.data;

public class MostItemData {
    private Integer qty;
    private String names;

    public MostItemData() {
    }

    public MostItemData(Integer qty, String names) {
        this.qty = qty;
        this.names = names;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
