public class exercise05 {
    public static void main(String[] args) {
        int letterInt = (int) 'ю';
        for (int i = letterInt - 1; i >= (letterInt - 10); i--) {
            System.out.println((char) i);
        }
    }
}
