import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class myClassForSaveFotoNasa {
    public static void main(String[] args) throws IOException {
        String filePath = "picture_NASA_of_day.jpg";
        File file = new File(filePath);

        FileInformation fileInfo = new FileInformation();

        fileInfo.fileName = file.getName();
        fileInfo.absolutePath = file.getAbsolutePath();
        fileInfo.size = file.length();
        fileInfo.imageData = loadImageAsBytes(filePath);

    }

    public static byte[] loadImageAsBytes(String filePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(filePath));
        if (image == null) {
            throw new IOException("Не удалось загрузить изображение.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        byte[] imageData = baos.toByteArray();
        baos.close();

        System.out.println("Изображение загружено и сохранено в виде байтов.");

        return imageData;
    }
}
