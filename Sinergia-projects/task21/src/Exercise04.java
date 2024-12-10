public class Exercise04 {
    private int num1;
    private int num2;
    private int num3;

    public static void main(String[] args) {
        int a = 46, b = 3, c = 10;

        Exercise04 exercise = new Exercise04();

        exercise.initialization(a, b, c);

        exercise.printMax();

    }

    private void initialization(int a, int b, int c) {
        this.num1 = a;
        this.num2 = b;
        this.num3 = c;
    }

    private int getMax() {
        int max = this.num1;
        if (this.num2 > max) {
            max = this.num2;
        }
        if (this.num3 > max) {
            max = this.num3;
        }
        return max;
    }

    public void printMax() {
        System.out.println("Наибольшее из трех чисел: " + this.getMax());
    }
}

