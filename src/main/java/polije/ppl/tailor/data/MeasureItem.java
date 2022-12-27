package polije.ppl.tailor.data;

import jakarta.validation.constraints.NotNull;

public class MeasureItem {
    @NotNull(message = "Nama ukuran harus diisi")
    private String name;

    @NotNull(message = "Nilai ukuran harus diisi")
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
