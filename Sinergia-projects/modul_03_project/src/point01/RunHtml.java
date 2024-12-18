package point01;

import java.io.IOException;

public class RunHtml {
    public static void main(String[] args) throws IOException {
        HtmlFileHandler htmlHandler = new HtmlFileHandler("transactions.html");
        EnterTheData enteredData = new EnterTheData();

        htmlHandler.processTransactionFile(enteredData);
    }
}
