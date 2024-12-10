public class exercise08 {
    public static void main(String[] args) {

        String strA = "false";
        boolean booleanA = true;

        if (strA == "true"){
            booleanA = true;
        }

        if (strA == "false"){
            booleanA = false;
        }

        System.out.println(booleanA);

        // OR

        boolean booleanB = Boolean.valueOf(strA);

        System.out.println(booleanB);
    }
}
