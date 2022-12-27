package polije.ppl.tailor.service.validation;

import jakarta.validation.constraints.NotNull;
import polije.ppl.tailor.data.ComboItem;

public class MeasureValidation {
    @NotNull(message = "Pelanggan harus diisi")
    private ComboItem customer;

    public MeasureValidation(ComboItem customer) {
        this.customer = customer;
    }
}
