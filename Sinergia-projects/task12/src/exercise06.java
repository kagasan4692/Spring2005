public class exercise06 {
    public static void main(String[] args) {
        int i = 0;
        for (char letter = 'а'; letter <= 'я'; letter++) {
            i++;
            if (i == 1) {
                System.out.println(letter);
            } else if (i == 2) {
                i = 0;
            }

        }
    }
}
