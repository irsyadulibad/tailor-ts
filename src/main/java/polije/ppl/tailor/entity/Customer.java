package polije.ppl.tailor.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer implements Entity {
    public final static String tableName = "customers";

    private Integer id;

    @NotNull(message = "Umur harus diisi")
    private Integer age;

    @NotBlank(message = "Nama lengkap harus diisi")
    private String fullname;

    @NotBlank(message = "No HP harus diisi")
    @Size(min = 11, message = "No HP tidak valid")
    private String phone;

    @NotBlank(message = "Alamat harus diisi")
    private String address;

    public Customer() {}

    public Customer(String fullname, Integer age, String phone, String address) {
        this.age = age;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
