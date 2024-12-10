import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class exercise08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру");

        int number = scanner.nextInt();
        String strSearch = "+" + number;

        String phoneCodeCountries = getPhoneCodeJson();

        boolean isFind = false;
        do {
            String phoneCode = getQuoteDataPhone(phoneCodeCountries);

            if (phoneCode.equals("Телефонный код не найден")) {
                System.out.println(phoneCode);
                isFind = true;

            } else {
                int index = phoneCode.lastIndexOf(strSearch);

                if (index == -1) {
                    phoneCodeCountries = deleteQuoteDataPhone(phoneCodeCountries);

                } else {
                    System.out.println(getCountryPhoneCode(phoneCode));
                    isFind = true;
                }
            }


        } while (!isFind);

    }

    private static String getCountryPhoneCode(String phoneCode) {
        System.out.println(phoneCode);
        int quoteStart1 = phoneCode.lastIndexOf("name") + 7;
        int quoteEnd1 = phoneCode.lastIndexOf("dial_code") - 3;
        String country = phoneCode.substring(quoteStart1, quoteEnd1);

        int quoteStart2 = phoneCode.lastIndexOf("dial_code") + 12;
        int quoteEnd2 = phoneCode.lastIndexOf("code") - 3;
        String code = phoneCode.substring(quoteStart2, quoteEnd2);

        return country + " : " + code;
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private static String getPhoneCodeJson() throws IOException {
        System.out.println("Ищем телефонный код! Пожалуйста подождите!");
        System.out.println();

        return downloadWebPage("https://gist.githubusercontent.com/Goles/3196253/raw/9ca4e7e62ea5ad935bb3580dc0a07d9df033b451/CountryCodes.json");
    }

    private static String getQuoteDataPhone(String dataPhone) {

        int quoteStart = getIndexStart(dataPhone);
        int quoteEnd = getIndexEnd(dataPhone);

        String result;

        if (quoteStart == -1 || quoteEnd == -1) {
            result = "Телефонный код не найден";

        } else {
            result = dataPhone.substring(quoteStart, quoteEnd);

        }

        return result;
    }

    private static String deleteQuoteDataPhone(String dataPhone) {
        StringBuilder string = new StringBuilder(dataPhone);

        int quoteStart = getIndexStart(dataPhone);
        int quoteEnd = getIndexEnd(dataPhone);

        return string.delete(quoteStart, quoteEnd).toString();

    }

    private static Integer getIndexStart(String getDataPhone) {
        return getDataPhone.lastIndexOf('{');
    }

    private static Integer getIndexEnd(String getDataPhone) {
        return getDataPhone.lastIndexOf('}') + 1;
    }

}
