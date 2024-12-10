package exercise01;

public class FileSystemEntry {
    private String name;
    private String creationDate;

    public FileSystemEntry(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String toString() {
        return "Name: " + name + ", Creation Date: " + creationDate;
    }
}