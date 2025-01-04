package exercise02;

import java.io.IOException;

public class RunExercise {
    public static void main(String[] args) throws IOException {
        WikiViewer wikiViewer = new WikiViewer();
        wikiViewer.run();
        System.out.println("Текст параграфов рандомной страницы из WIKI: \n" + wikiViewer);// Неявный вызов toString()
    }
}
