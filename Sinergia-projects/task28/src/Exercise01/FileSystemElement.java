package Exercise01;
import java.util.ArrayList;

public class FileSystemElement {
    private String name;

    public FileSystemElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display(String indent) {
        throw new UnsupportedOperationException("Обновлена структура файловой системы: метод 'display' должен быть реализован в подклассах.");
    }
}

class File extends FileSystemElement {
    private long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void display(String indent) {
        System.out.println(indent + "File: " + getName() + " (Size: " + size + " bytes)");
    }
}

class Directory extends FileSystemElement {
    private ArrayList elements;

    public Directory(String name) {
        super(name);
        this.elements = new ArrayList();
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public void removeElement(FileSystemElement element) {
        elements.remove(element);
    }

    public void display(String indent) {
        System.out.println(indent + "Directory: " + getName());
        for (int i = 0; i < elements.size(); i++) {
            FileSystemElement element = (FileSystemElement) elements.get(i); // Приведение типов
            element.display(indent + "  ");
        }

    }
}