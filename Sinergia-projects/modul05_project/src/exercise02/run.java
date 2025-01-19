package exercise02;

public class run {
    public static void main(String[] args) {
            Flower rose = new Rose("Netherlands", 7, 3.5);
            Flower carnation = new Carnation("Colombia", 10, 2.0);
            Flower tulip = new Tulip("Turkey", 5, 4.0);
            Flower lily = new Lily("France", 8, 5.0);

            Flower[] bouquet1 = {rose, rose, carnation};
            Flower[] bouquet2 = {tulip, tulip, tulip, carnation};
            Flower[] bouquet3 = {lily, rose, tulip};

            double bouquet1Price = calculateBouquetPrice(bouquet1);
            double bouquet2Price = calculateBouquetPrice(bouquet2);
            double bouquet3Price = calculateBouquetPrice(bouquet3);

            sellFlowers(bouquet1);
            sellFlowers(bouquet2);
            sellFlowers(bouquet3);

            System.out.println("Стоимость букета 1: " + bouquet1Price + " USD");
            System.out.println("Стоимость букета 2: " + bouquet2Price + " USD");
            System.out.println("Стоимость букета 3: " + bouquet3Price + " USD");

            System.out.println("Общее количество проданных цветов: " + Flower.getTotalSold());
        }

        public static double calculateBouquetPrice(Flower[] bouquet) {
            double totalPrice = 0.0;
            for (Flower flower : bouquet) {
                totalPrice += flower.getPrice();
            }
            return totalPrice;
        }

        public static void sellFlowers(Flower[] bouquet) {
            for (Flower flower : bouquet) {
                flower.sell();
            }
        }
    }
