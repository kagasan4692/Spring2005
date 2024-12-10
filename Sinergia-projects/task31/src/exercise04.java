public class exercise04 {
//    Можно скрыть, что внутри создаётся объект наследника,
//    предоставляя только функциональность родителя (инкапсуляция).

//    Если вызывающему коду не нужны специфичные методы наследника,
//    возвращать объект базового класса удобнее.

//    Если нужно ограничить доступ к методам наследника.

    public static void main(String[] args) {
        HockeyPlayer hockeyPlayer = HockeyPlayerFactory.getHockeyPlayer();
        hockeyPlayer.HePlaysHockey();
//        hockeyPlayer.SavesTheGate(); // метод не доступен
    }
}

class HockeyPlayer {
    void HePlaysHockey() {
        System.out.println("Играет в хоккей");
    }
}

class Goalkeeper extends HockeyPlayer {
    void SavesTheGate() {
        System.out.println("Спасает ворота");
    }
}

class HockeyPlayerFactory {
    public static HockeyPlayer getHockeyPlayer() {
        return new Goalkeeper();
    }
}