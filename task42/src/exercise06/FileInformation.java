package exercise06;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileInformation {
    private File file;
    private String fileName;
    private String filePath;
    private long fileSize;
    private String lastModified;
    private boolean isDirectory;
    private boolean isFile;
    private boolean isReadable;
    private boolean isWritable;

    public FileInformation(String filePath) {
        this.file = new File(filePath);

        if (!file.exists()) {
            throw new IllegalArgumentException("Файл или директория не существует: " + filePath);
        }

        this.fileName = file.getName();
        this.filePath = file.getAbsolutePath();
        this.fileSize = file.isFile() ? file.length() : -1;
        this.lastModified = formatLastModified(file.lastModified());
        this.isDirectory = file.isDirectory();
        this.isFile = file.isFile();
        this.isReadable = file.canRead();
        this.isWritable = file.canWrite();
    }

    private String formatLastModified(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(timestamp);
    }

    private String getFileName() {
        return fileName;
    }

    private String getFilePath() {
        return filePath;
    }

    private long getFileSize() {
        return fileSize;
    }

    private String getLastModified() {
        return lastModified;
    }

    private boolean isDirectory() {
        return isDirectory;
    }

    private boolean isFile() {
        return isFile;
    }

    private boolean isReadable() {
        return isReadable;
    }

    private boolean isWritable() {
        return isWritable;
    }

    @Override
    public String toString() {
       String fileInfo = "Имя файла: " + getFileName() + "\n" +
        "Путь файла: " + getFilePath() + "\n" +
        "Размер файла: " + getFileSize() + " байт" + "\n" +
        "Последняя модификация: " + getLastModified() + "\n" +
        "Это директория? " + replaceBoolean(isDirectory()) + "\n" +
        "Это файл? " + replaceBoolean(isFile()) + "\n" +
        "Файл доступен для чтения? " + replaceBoolean(isReadable()) + "\n" +
        "Файл доступен для записи? " +  replaceBoolean(isWritable());
       
        return fileInfo;
    }

    private String replaceBoolean(boolean bool) {
        return bool ? "Да" : "Нет";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileInformation that = (FileInformation) obj;
        return this.isFile == that.isFile && this.isWritable == that.isWritable;
    }

}
