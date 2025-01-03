package exercise01;

public class GetFileInformation {
    public static void main(String[] args) {
        try {
            FileInformation fileInfo = new FileInformation("CsvFileHandler.java");
            System.out.println(fileInfo.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
