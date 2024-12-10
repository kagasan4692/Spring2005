package Exercise06;

import java.io.IOException;

public class Exercise06 {
    public static void main(String[] args) throws IOException {

        new CurrencyCourse().fetchExchangeRate();
        System.out.println();

        new CurrencyCourse("EUR", "RUB").fetchExchangeRate();
        System.out.println();

        new CurrencyCourse("USD", "RUB").fetchExchangeRate();
        System.out.println();

        String data = "2023-12-11";
        new CurrencyCourse("EUR", "RUB", new Url(data).url).fetchExchangeRate();
        System.out.println();

        new CurrencyCourse("USD", "RUB", new Url(data).url).fetchExchangeRate();
        System.out.println();

    }
}
