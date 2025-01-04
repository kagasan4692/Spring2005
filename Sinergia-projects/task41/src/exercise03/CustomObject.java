package exercise03;

public class CustomObject {
    private String name;
    private int id;

    public CustomObject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "exercise03.CustomObject {name='" + name + "', id=" + id + "}";
    }
}
