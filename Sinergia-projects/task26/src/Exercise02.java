public class Exercise02 {
    public static void main(String[] args) {
        int tableDimensions = 20;
        System.out.print("    ");
        for (int i = 1; i <= tableDimensions; i++) {
            if (i < 10) {
                System.out.print("   " + i);
            } else {
                System.out.print("  " + i);
            }

        }

        System.out.println();
        System.out.println("    --------------------------------------------------------------------------------");

        for (int i = 1; i <= tableDimensions; i++) {
            if (i < 10) {
                System.out.print(i + "  |");
            } else {
                System.out.print(i + " |");
            }

            for (int j = 1; j <= tableDimensions; j++) {
                if (i * j < 10) {
                    System.out.print("   " + i * j);
                } else if (i * j >= 10 && i * j < 100) {
                    System.out.print("  " + i * j);
                } else {
                    System.out.print(" " + i * j);
                }

            }
            System.out.println();
        }
    }
}
