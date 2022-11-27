package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.entity.Transaction;
import polije.ppl.tailor.entity.TransactionDetail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionDetailRepositoryTest {
    private static TransactionDetail detail;
    private static Transaction transaction = TransactionRepository.get().get(0);
    private static Package pkg = PackageRepository.get().get(0);
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("detail_id", 1);
        put("transaction_id", transaction.getId());
        put("package_id", pkg.getId());
    }};

    @Test @Order(1)
    public void testAdd() {
        TransactionDetail dtl = new TransactionDetail(
            1,
            20,
            50000,
            pkg,
            transaction,
            "Uniform"
        );

        detail = dtl;
        assertTrue(TransactionDetailRepository.add(dtl));
    }

    @Test @Order(2)
    public void testGet() {
        TransactionDetail dtl = TransactionDetailRepository.get(keywords).get(0);

        assertEquals(detail.getClothName(), dtl.getClothName());
        assertEquals(detail.getPrice(), dtl.getPrice());
    }

    @Test @Order(3)
    public void testGetAll() {
        TransactionDetail detail = new TransactionDetail();
        detail.setClothName("T-Shirt");
        detail.setPackage(pkg);
        detail.setTransaction(transaction);
        detail.setPrice(2000);
        detail.setQty(3);

        assertTrue(TransactionDetailRepository.add(detail));
        List<TransactionDetail> details = TransactionDetailRepository.get();

        assertEquals(2, details.size());
    }

    @Test @Order(4)
    public void testUpdate() {
        TransactionDetail data = detail;
        detail.setQty(2);

        assertTrue(TransactionDetailRepository.update(detail, data));
        detail = TransactionDetailRepository.get(keywords).get(0);

        assertNotEquals(20, detail.getQty());
        assertEquals(2, detail.getQty());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = detail.getId();
        assertTrue(TransactionDetailRepository.delete(id));
    }
}
