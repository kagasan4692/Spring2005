public class exercise07 {
    public static void main(String[] args) {
        int i = 0;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            i++;
            if (i == 1) {
                System.out.println(letter);
            } else if (i == 3) {
                i = 0;
            }

        }
    }
}
