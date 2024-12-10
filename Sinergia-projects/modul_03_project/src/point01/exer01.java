package point01;

import java.io.IOException;


public class exer01 {
    public static void main(String[] args) throws IOException{
        TxtFileHandler txtHandler = new TxtFileHandler("example.txt");

        EnterTheData enteredData = new EnterTheData();
        TransactionArrayProvider dataTransactions = new TransactionArrayProvider();
        TransactionsDataArray dataByMonth = new TransactionsDataArray();


        try {

            String input = txtHandler.read();

            if (input.equals("")){
                System.out.println("Данных в файле нет!");
                System.out.println("Введите новые данные!");

                writeDataToFile(txtHandler, enteredData.getData());
            } else {
                System.out.println("Получаю данные");

//                writeDataToFile(txtHandler, enteredData.getData());
                String[] data = dataTransactions.createDataArray(txtHandler.read());
                String[][] allTransaction = dataByMonth.getTransactionsArray(data);

                printTwoDimensionalArray(allTransaction);
            }



        } catch (IOException e) {
            System.out.println("Нет файла!");
            System.out.println("Введите новые данные!");

            writeDataToFile(txtHandler, enteredData.getData());
        }

    }

    public static void printTwoDimensionalArray(String[][] array) {
        for (int i = 0; i < array.length; i++) { // Итерируем строки
            for (int j = 0; j < array[i].length; j++) { // Итерируем столбцы
                System.out.print(array[i][j] + "\t"); // Выводим элемент с табуляцией
            }
            System.out.println(); // Переход на новую строку после строки массива
        }
    }


    public static void writeDataToFile(TxtFileHandler txtHandler, String data) {
        try {
            txtHandler.write(txtHandler.read() + data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
