public class exercise04 {
    public static void main(String[] args) {
        int j = 1025;
        char word1 = ' ';
        while(j <= 1071){
            if (j == 1025){
                word1 = (char) j;
            }

            if (j >= 1040 && j <= 1071){
                System.out.println((char) j + " " + (char) (j + 32));
                if (j == 1045){
                    System.out.println(word1 + " " + (char) 1105);
                }
            }
            j++;
        }
    }

}
