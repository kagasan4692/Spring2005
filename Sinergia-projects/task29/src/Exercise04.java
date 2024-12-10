public class Exercise04 {
    public static void main(String[] args) {
        // Используем разные конструкторы для создания экземпляров
        WebSite defaultSite = new WebSite();
        WebSite blog = new WebSite("Яндекс", "https://yandex.ru");
        WebSite shop = new WebSite("Озон", "https://ozon.ru", "ООО Интернет Решения");
        WebSite newsPortal = new WebSite("РБК", "https://www.rbc.ru", "РосБизнесКонсалтинг", 1500000);
    }
}

class WebSite {
    private String name;
    private String url;
    private String owner;
    private int dailyVisitors;

    public WebSite() {
        this.name = "Неизвестный сайт";
        this.url = "http://example.com";
        this.owner = "Неизвестный владелец";
        this.dailyVisitors = 0;
        System.out.println("Создан сайт с параметрами по умолчанию:\n" + this);
    }

    public WebSite(String name, String url) {
        this.name = name;
        this.url = url;
        this.owner = "Неизвестный владелец";
        this.dailyVisitors = 0;
        System.out.println("Создан сайт с названием и URL:\n" + this);
    }

    public WebSite(String name, String url, String owner) {
        this.name = name;
        this.url = url;
        this.owner = owner;
        this.dailyVisitors = 0;
        System.out.println("Создан сайт с названием, URL и владельцем:\n" + this);
    }

    public WebSite(String name, String url, String owner, int dailyVisitors) {
        this.name = name;
        this.url = url;
        this.owner = owner;
        this.dailyVisitors = dailyVisitors;
        System.out.println("Создан сайт со всеми параметрами:\n" + this);
    }

    public String toString() {
        return "Название: " + name + "\nURL: " + url + "\nВладелец: " + owner + "\nЕжедневные посетители: " + dailyVisitors + "\n";
    }
}