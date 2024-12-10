package Exercise06;

import java.io.IOException;

public class CurrencyCourse {
    private String baseCurrency;
    private String targetCurrency;
    private String apiUrl;
    private double usdValue;
    private double eurValue;

    public CurrencyCourse() throws IOException {
        this.baseCurrency = "USD";
        this.targetCurrency = "EUR";
        this.apiUrl = new Url().url;
        this.usdValue = new GetCurrencyCourse(this.apiUrl).usdValue;
        this.eurValue = new GetCurrencyCourse(this.apiUrl).eurValue;
    }

    public CurrencyCourse(String baseCurrency, String targetCurrency) throws IOException {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.apiUrl = new Url().url;
        this.usdValue = new GetCurrencyCourse(this.apiUrl).usdValue;
        this.eurValue = new GetCurrencyCourse(this.apiUrl).eurValue;

        System.out.println("Создан CurrencyCourse для: " + baseCurrency + " -> " + targetCurrency);
    }

    public CurrencyCourse(String baseCurrency, String targetCurrency, String url) throws IOException {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.apiUrl = url;
        this.usdValue = new GetCurrencyCourse(this.apiUrl).usdValue;
        this.eurValue = new GetCurrencyCourse(this.apiUrl).eurValue;

        System.out.println("Создан CurrencyCourse для: " + baseCurrency + " -> " + targetCurrency);
    }

    public void fetchExchangeRate() {
        switch (baseCurrency) {
            case "USD":
                System.out.println("Курс валют " + baseCurrency + " -> " + targetCurrency + " равен: " + this.usdValue);
                break;
            case "EUR":
                System.out.println("Курс валют " + baseCurrency + " -> " + targetCurrency + " равен: " + this.eurValue);
                break;
        }
    }

}
