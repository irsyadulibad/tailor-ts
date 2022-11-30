package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.entity.Package;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackageRepositoryTest {
    private static Repository<Package> repo = new PackageRepository();
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("name", "T-Shirt");
    }};

    @Test @Order(1)
    public void testAdd() {
        Package pack = new Package(
            100000,
            "T-Shirt"
        );

        assertTrue(repo.add(pack));
    }

    @Test @Order(2)
    public void testGet() {
        Package pkg = repo.get(keywords).get(0);
        assertEquals("T-Shirt", pkg.getName());
    }

    @Test @Order(3)
    public void testGetAll() {
        Package pkg = new Package();
        pkg.setPrice(20000);
        pkg.setName("Gown");

        assertTrue(repo.add(pkg));
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Package pkg = repo.get(keywords).get(0);
        pkg.setPrice(50000);

        repo.update(pkg);
        pkg = repo.get(keywords).get(0);

        assertNotEquals(100000, pkg.getPrice());
        assertEquals(50000, pkg.getPrice());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = repo.get(keywords).get(0).getId();
        assertTrue(repo.delete(id));
    }
}
