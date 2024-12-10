package exercise02;

public class Administrator extends User {
    private String adminLevel;

    public Administrator(String username, String email, String password, String adminLevel) {
        super(username, email, password);
        this.adminLevel = adminLevel;
    }

    public String toString() {
        return super.toString() + ", Уровень администратора: " + adminLevel;
    }
}
