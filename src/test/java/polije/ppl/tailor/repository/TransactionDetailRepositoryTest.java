package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.data.TransactionStatus;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.entity.Transaction;
import polije.ppl.tailor.entity.TransactionDetail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionDetailRepositoryTest {
    private static Customer customer;
    private static Account account;
    private static Package pkg;
    private static Transaction transaction;

    private static Repository<Package> pkgRepo = new PackageRepository();
    private static Repository<Account> accRepo = new AccountRepository();
    private static Repository<Customer> custRepo = new CustomerRepository();
    private static Repository<Transaction> transRepo = new TransactionRepository();
    private static Repository<TransactionDetail> repo = new TransactionDetailRepository();
    private static Integer accountId, customerId, packageId, transactionId, detailId;


    @BeforeAll
    public static void init() {
        accountId = accRepo.add(new Account(
            "David","david@test.com","david","david123", AccountRole.tailor
        ));

        customerId = custRepo.add(new Customer(
            "Angel", 20, "098765897652", "Jember"
        ));

        packageId = pkgRepo.add(new Package(
            50000, "Batik"
        ));

        account = accRepo.get(accountId);
        customer = custRepo.get(customerId);
        pkg = pkgRepo.get(packageId);

        transRepo.add(new Transaction(
            10000, account, customer, LocalDate.now(), "-", TransactionStatus.finish
        ));

        transaction = transRepo.get(transactionId);
    }

    @AfterAll
    public static void tearDown() {
        transRepo.delete(transaction.getId());
        custRepo.delete(customer.getId());
        accRepo.delete(account.getId());
        pkgRepo.delete(pkg.getId());
    }

    @Test @Order(1)
    public void testAdd() {
        TransactionDetail detail = new TransactionDetail(
            10, 5000, pkg, transaction, "Batik Lengan Panjang"
        );

        detailId = repo.add(detail);
        assertTrue(detailId > 0);
    }

    @Test @Order(2)
    public void testGet() {
        TransactionDetail detail = repo.get(detailId);
        assertEquals(5000, detail.getPrice());
    }

    @Test @Order(3)
    public void testGetAll() {
        TransactionDetail detail = new TransactionDetail(
            10, 6000, pkg, transaction, "Batik Lengan Pendek"
        );

        assertTrue(repo.add(detail) > 0);
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        TransactionDetail detail = repo.get(detailId);
        detail.setQty(50);

        assertTrue(repo.update(detail));
        detail = repo.get(detailId);

        assertNotEquals(10, detail.getQty());
        assertEquals(50, detail.getQty());
    }

    @Test @Order(5)
    public void testDelete() {
        assertTrue(repo.delete(detailId));
    }
}
