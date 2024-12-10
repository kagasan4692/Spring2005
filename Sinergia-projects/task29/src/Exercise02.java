public class Exercise02 {
    public static void main(String[] args) {

        Observer obj1 = new Observer("1 объект");
        Observer obj2 = new Observer("2 объект");
        Observer obj3 = new Observer("3 объект");
        Observer meat = new Observer("мясо");
    }
}

class Observer {
    private String name;

    public Observer(String name) {
        this.name = name;

        System.out.println("Создан объект класса Observer с именем: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}