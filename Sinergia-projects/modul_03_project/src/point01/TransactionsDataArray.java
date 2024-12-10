package point01;

public class TransactionsDataArray {
    private static String[][] getDataArray(String[] data) {
        String[][] result = new String[data.length][3];
        for (int i = 0; i < data.length; i++) {
            String[] transaction = new String[3];
            transaction[0] = getDescription(data[i]);
            transaction[1] = getDate(data[i]);
            transaction[2] = getSum(data[i]);

            result[i] = transaction;
        }

        return result;
    }

    private static String getDescription(String inputValue) {
        int startIndex = inputValue.indexOf("Описание сделки") + 17;
        int endIndex = inputValue.indexOf(';', startIndex);

        return inputValue.substring(startIndex, endIndex).trim();
    }


    private static String getDate(String inputValue) {
        int startIndex = inputValue.indexOf("Текущая дата и время") + 21;
        int endIndex = inputValue.indexOf(';', startIndex) - 9;

        return inputValue.substring(startIndex, endIndex).trim();
    }

    private static String getSum(String inputValue) {
        int startIndex = inputValue.indexOf("Сумма сделки") + 14;
        int endIndex = inputValue.indexOf(';', startIndex);

        return inputValue.substring(startIndex, endIndex).trim();
    }

    public static String[][] getTransactionsArray(String[] data) {
        return getDataArray(data);
    }

}
