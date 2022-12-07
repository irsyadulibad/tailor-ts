package polije.ppl.tailor.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import polije.ppl.tailor.data.AccountRole;

public class Account implements Entity {
    public final static String tableName = "accounts";

    private Integer id;

    @NotBlank(message = "Nama Lengkap Harus diisi")
    private String fullname;

    @Email(message = "Email harus valid")
    private String email;

    @NotBlank(message = "Username Harus diisi")
    @Size(max = 15, message = "Username idak boleh melebihi 15 karakter")
    private String username;

    @NotBlank(message = "Password Harus diisi")
    @Size(min = 8, message = "Password minimal 8 karakter")
    private String password;

    @NotNull(message = "Harus diisi")
    private AccountRole role;

    public Account() {}

    public Account(String fullname, String email, String username, String password, AccountRole role) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountRole getRole() {
        return role;
    }

    public void setRole(AccountRole role) {
        this.role = role;
    }
}
