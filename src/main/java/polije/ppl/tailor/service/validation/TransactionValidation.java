package polije.ppl.tailor.service.validation;

import jakarta.validation.constraints.NotNull;
import polije.ppl.tailor.data.ComboItem;

public class TransactionValidation {
    @NotNull(message = "Pelanggan harus diisi")
    private ComboItem customer;

    @NotNull(message = "Penjahit harus diisi")
    private ComboItem tailor;

    public TransactionValidation(ComboItem customer, ComboItem tailor) {
        this.customer = customer;
        this.tailor = tailor;
    }
}
