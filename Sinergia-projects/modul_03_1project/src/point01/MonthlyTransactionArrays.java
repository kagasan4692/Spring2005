package point01;

public class MonthlyTransactionArrays {

    public static String[][][] splitByMonthAndYear(String[][] data) {

        String[][][] groupedData = new String[12][][];
        int[] groupSizes = new int[12];

        for (int i = 0; i < data.length; i++) {

            String date = data[i][1];
            int yearMonthIndex = Integer.parseInt(date.substring(5, 7)) - 1;

            if (groupedData[yearMonthIndex] == null) {
                groupedData[yearMonthIndex] = new String[data.length][];
            }

            groupedData[yearMonthIndex][groupSizes[yearMonthIndex]] = data[i];
            groupSizes[yearMonthIndex]++;
        }

        for (int i = 0; i < groupedData.length; i++) {
            if (groupedData[i] != null) {
                String[][] trimmedGroup = new String[groupSizes[i]][];
                System.arraycopy(groupedData[i], 0, trimmedGroup, 0, groupSizes[i]);
                groupedData[i] = trimmedGroup;
            }
        }

        return groupedData;
    }
}
