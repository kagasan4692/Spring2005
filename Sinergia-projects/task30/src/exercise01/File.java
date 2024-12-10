package exercise01;

public class File extends FileSystemEntry {
    private long size;
    private String extension;

    public File(String name, String creationDate, long size, String extension) {
        super(name, creationDate);
        this.size = size;
        this.extension = extension;
    }

    public String toString() {
        return "Файл: " + super.toString() + ", Размер: " + size + " bytes, Расширение: " + extension;
    }
}
