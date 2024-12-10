package exercise01;

import java.util.ArrayList;

public class Exercise01 {
    public static void main(String[] args) {
        Directory root = new Directory("Пост", "2024-11-28");

        File file1 = new File("Документ", "2024-11-28", 1024, "txt");
        File file2 = new File("Фотография", "2024-11-28", 2048, "jpg");

        root.addEntry(file1);
        root.addEntry(file2);

        print(root);
    }

    public static void print(Directory root){
        System.out.println(root);

        ArrayList entries = root.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            System.out.print("=>  ");
            System.out.println(entries.get(i));
        }
    }

}
