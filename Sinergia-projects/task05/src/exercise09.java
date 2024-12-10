public class exercise09 {
    public static void main(String[] args) {
// a-z : 97 - 122;
// A-Z : 65 - 90

        int i = 64;
        while (i < 122){
            i++;
            char liter = (char) i;
            if (i < 97 && i > 90){

            } else {
                System.out.println(liter);
            }

        }
    }
}