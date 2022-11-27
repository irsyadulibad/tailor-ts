package polije.ppl.tailor.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import polije.ppl.tailor.data.MeasureItem;

public class Measure  implements EntityInterface {
    public static String tableName = "measures";

    private Integer id;
    private String clothType;
    private JSONArray items = new JSONArray();
    private Customer customer;

    public Measure() {}

    public Measure(Integer id, Customer customer, String clothType, String items) {
        this.id = id;
        this.customer = customer;
        this.clothType = clothType;
        this.items = new JSONArray(items);
    }

    public Measure(Integer id, Customer customer, String clothType, MeasureItem[] items) {
        this.id = id;
        this.customer = customer;
        this.clothType = clothType;
        this.items = new JSONArray(items);
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }

    public JSONArray getItems() {
        return this.items;
    }

    public void setItems(String items) {
        this.items = new JSONArray(items);
    }

    public void setItems(MeasureItem[] items) {
        this.items = new JSONArray(items);
    }

    public List<MeasureItem> getItemsCollection() {
        List<MeasureItem> measureItems = new ArrayList<>();

        items.forEach((item) -> {
            JSONObject obj = new JSONObject(item.toString());
            measureItems.add(new MeasureItem(
                (String) obj.get("name"),
                (Integer) obj.get("value")
            ));
        });

        return measureItems;
    }
}
