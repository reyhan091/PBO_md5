package tugas_asistensimd5;

public class Projectperpus {
    String email, password;

    public Projectperpus(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Projectperpus() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}