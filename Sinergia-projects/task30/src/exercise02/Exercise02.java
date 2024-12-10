package exercise02;

public class Exercise02 {
    public static void main(String[] args) {
        User user = new User("Никотин Дмитрий", "nikota@example.com", "nikota12$");

        Administrator admin = new Administrator("Администратор 1", "admin1@example.com", "adminpass", "SuperAdmin");

        Moderator moderator = new Moderator("Варгунин Евгений", "varagen@example.com", "modpass", "Forum");

        System.out.println(user.toString());
        System.out.println(admin.toString());
        System.out.println(moderator.toString());
    }
}
