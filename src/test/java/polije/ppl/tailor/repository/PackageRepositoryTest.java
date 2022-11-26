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
    private static Package pkg;
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("package_id", 1);
        put("price", 100000);
    }};

    @Test @Order(1)
    public void testAdd() {
        Package pack = new Package(
            1,
            100000,
            "T-Shirt"
        );

        pkg = pack;
        assertTrue(PackageRepository.add(pack));
    }

    @Test @Order(2)
    public void testGet() {
        Package pkg = PackageRepository.get(keywords).get(0);
        assertEquals("T-Shirt", pkg.getName());
    }

    @Test @Order(3)
    public void testGetAll() {
        Package pk = new Package();
        pk.setPrice(20000);
        pk.setName("Gown");

        PackageRepository.add(pk);
        assertEquals(2, PackageRepository.get().size());
    }

    @Test @Order(4)
    public void testUpdate() {
        Package data = pkg;
        data.setName("Uniform");

        PackageRepository.update(pkg, data);
        pkg = PackageRepository.get(keywords).get(0);

        assertNotEquals("T-Shirt", pkg.getName());
        assertEquals("Uniform", pkg.getName());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = pkg.getId();
        assertTrue(PackageRepository.delete(id));
    }
}
