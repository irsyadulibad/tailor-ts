package polije.ppl.tailor.data;

public class MeasureItem {
    private String name;
    private Integer value;

    public MeasureItem() {}

    public MeasureItem(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
