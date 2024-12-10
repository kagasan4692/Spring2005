package Exercise01;

public class Exercise01 {
    public static void main(String[] args) {

        File file1 = new File("file1.txt", 500);
        File file2 = new File("file2.txt", 1000);
        File file3 = new File("file3.log", 1500);
        File file4 = new File("README.md", 200);

        Directory documents = new Directory("Documents");
        Directory projects = new Directory("Projects");
        Directory logs = new Directory("Logs");

        documents.addElement(file1);
        documents.addElement(file2);

        logs.addElement(file3);

        projects.addElement(documents);
        projects.addElement(logs);
        projects.addElement(file4);

        System.out.println("Исходная структура файловой системы:");
        projects.display("");

        System.out.println("\nУдаление файла 3.log из журналов...");
        logs.removeElement(file3);

        File file5 = new File("new_document.docx", 750);
        documents.addElement(file5);

        System.out.println("\nОбновленная структура файловой системы:");
        projects.display("");

    }
}
