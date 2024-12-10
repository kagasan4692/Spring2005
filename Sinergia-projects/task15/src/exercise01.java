public class exercise01 {
    public static void main(String[] args) {
        final int[] finalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (final int[] i = {0}; i[0] < finalArray.length; i[0]++) { // Обхожу условие не использовать переменные кроме Final
            finalArray[i[0]] = finalArray[i[0]] * 2;
        }

//        for (int j = 0; j < finalArray.length; j++) {
//            System.out.println(finalArray[j]);
//        }

    }
}
