package point01;

import java.io.IOException;

public class RunTxt {

    public static void main(String[] args) throws IOException {
        TxtFileHandler txtHandler = new TxtFileHandler("transactions.txt");
        EnterTheData enteredData = new EnterTheData();

        txtHandler.processTransactionFile(enteredData);

    }

}
