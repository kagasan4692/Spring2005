package common;

import java.util.ArrayList;
import java.util.List;

public class AppView {
    private final String title;
    private final List<AppView> children;

    public AppView(String title, List<AppView> children) {
        this.title = title;
        this.children = (children != null) ? children : new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<AppView> getChildren() {
        return children;
    }

    public void action() {
        System.out.println("Вы на странице: " + title);
    }
}
