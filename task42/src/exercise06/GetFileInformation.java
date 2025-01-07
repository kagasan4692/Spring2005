package exercise06;

public class GetFileInformation {
    public static void main(String[] args) {
        try {
            FileInformation fileInfoCsv = new FileInformation("CsvFileHandler.java");

            FileInformation fileInfoHtml = new FileInformation("HtmlFileHandler.java");

            boolean bool = fileInfoCsv.equals(fileInfoHtml);
            System.out.println(bool);// Является ли доступным для записи файлом!

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
