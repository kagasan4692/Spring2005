package Exercise02;

public class Exercise02 {
    public static void main(String[] args) {

        User user = new User("user1", "user1@example.com");
        user.performAction();

        Admin admin = new Admin("admin1", "admin1@example.com");
        admin.performAction();
        admin.manageUsers();

        Moderator moderator = new Moderator("moderator1", "moderator1@example.com");
        moderator.performAction();
        moderator.moderateContent();
    }
}
