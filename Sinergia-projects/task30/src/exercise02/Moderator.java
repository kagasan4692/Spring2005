package exercise02;

public class Moderator extends User {
    private String moderatedSection;

    public Moderator(String username, String email, String password, String moderatedSection) {
        super(username, email, password);
        this.moderatedSection = moderatedSection;
    }

    public String toString() {
        return super.toString() + ", Модераторский раздел: " + moderatedSection;
    }
}
