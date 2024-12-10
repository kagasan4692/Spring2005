import java.util.Random;

public class Exercise04 {
    public static void main(String[] args) {
        Exception[] checkedExceptions = {
                new java.io.IOException("Checked Exception 1: IOException"),
                new java.io.FileNotFoundException("Checked Exception 2: FileNotFoundException"),
                new java.sql.SQLException("Checked Exception 3: SQLException"),
                new java.text.ParseException("Checked Exception 4: ParseException", 0),
                new javax.naming.NamingException("Checked Exception 5: NamingException"),
                new javax.xml.parsers.ParserConfigurationException("Checked Exception 6: ParserConfigurationException"),
                new java.rmi.RemoteException("Checked Exception 7: RemoteException"),
                new java.net.MalformedURLException("Checked Exception 8: MalformedURLException"),
                new java.security.GeneralSecurityException("Checked Exception 9: GeneralSecurityException"),
                new java.lang.reflect.InvocationTargetException(null, "Checked Exception 10: InvocationTargetException")
        };

        RuntimeException[] uncheckedExceptions = {
                new java.lang.NullPointerException("Unchecked Exception 1: NullPointerException"),
                new java.lang.ArithmeticException("Unchecked Exception 2: ArithmeticException"),
                new java.lang.ArrayIndexOutOfBoundsException("Unchecked Exception 3: ArrayIndexOutOfBoundsException"),
                new java.lang.StringIndexOutOfBoundsException("Unchecked Exception 4: StringIndexOutOfBoundsException"),
                new java.lang.ClassCastException("Unchecked Exception 5: ClassCastException"),
                new java.lang.IllegalArgumentException("Unchecked Exception 6: IllegalArgumentException"),
                new java.lang.IllegalStateException("Unchecked Exception 7: IllegalStateException"),
                new java.util.ConcurrentModificationException("Unchecked Exception 8: ConcurrentModificationException"),
                new java.util.NoSuchElementException("Unchecked Exception 9: NoSuchElementException"),
                new java.lang.UnsupportedOperationException("Unchecked Exception 10: UnsupportedOperationException")
        };

        Throwable randomException = getRandomException(checkedExceptions, uncheckedExceptions);
        System.out.println("Случайное исключение: " + randomException.getMessage());
    }

    public static Throwable getRandomException(Exception[] checked, RuntimeException[] unchecked) {
        Random random = new Random();
        boolean pickChecked = random.nextBoolean();

        if (pickChecked) {
            int index = random.nextInt(checked.length);
            return checked[index];
        } else {
            int index = random.nextInt(unchecked.length);
            return unchecked[index];
        }
    }
}
