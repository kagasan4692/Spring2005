package Exercise02;

public class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void performAction() {
        System.out.println("Пользователь " + username + " выполняет общее действие.");
    }
}

class Admin extends User {
    public Admin(String username, String email) {
        super(username, email);
    }

    public void manageUsers() {
        System.out.println("Администратор " + getUsername() + " управляет пользователями.");
    }

    public void performAction() {
        System.out.println("Администратор " + getUsername() + " выполняет административное действие.");
    }
}

class Moderator extends User {
    public Moderator(String username, String email) {
        super(username, email);
    }

    public void moderateContent() {
        System.out.println("Модератор " + getUsername() + " модерирует контент.");
    }

    public void performAction() {
        System.out.println("Модератор " + getUsername() + " выполняет модерацию.");
    }
}
