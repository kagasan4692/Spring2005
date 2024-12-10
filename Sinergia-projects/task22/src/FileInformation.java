public class FileInformation {
    String fileName;
    long fileSize;
    String fileType;
    String creationDate;

    public FileInformation(String[] dataArray) {
        this.fileName = dataArray[0];
        this.fileSize = Long.parseLong(dataArray[1]);
        this.fileType = dataArray[2];
        this.creationDate = dataArray[3];
    }

}
