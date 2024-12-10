public class exercise02 {

    public static void main(String[] args) {
        User user = new User("Обычный пользователь");
        Moderator moderator = new Moderator("Модератор");
        Admin admin = new Admin("Системный администратор");

        printUserName(user);
        printUserName(moderator);
        printUserName(admin);
    }

    public static void printUserName(User user) {
        System.out.println("Имя пользователя: " + user.getName());
    }
}


class User {
    public String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Moderator extends User {
    public Moderator(String name) {
        super(name);
    }
}

class Admin extends User {
    public Admin(String name) {
        super(name);
    }
}

