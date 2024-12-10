public class exercise11 {
    public static void main(String[] args) {
// буду выводить случайную строчную букву
        double random = Math.random() * 26 + 97;
        int randomNumber = (int) Math.floor(random);
        char randomLiter = (char) randomNumber;
        System.out.println(randomLiter);

    }
}
