public class Exercise05 {
    String part1;
    String part2;
    String part3;

    public static void main(String[] args) {
        String string1 = "Зачем нужно ключевое слово this?";
        String string2 = "Когда стоит использовать слово this?";
        String string3 = "Совершенствование навыков работы с классами...";

        Exercise05 exercise = new Exercise05();

        exercise.stringConcat(string1, string2, string3);
        exercise.printConcatenatedString();
    }

    private void stringConcat(String string1, String string2, String string3) {
        this.part1 = string1;
        this.part2 = string2;
        this.part3 = string3;
    }

    private String concatenate() {
        return this.part1 + " " + this.part2 + " " + this.part3;
    }

    private void printConcatenatedString() {
        System.out.println("ОДНА БОЛЬШАЯ СТРОКА: ");
        System.out.println(this.concatenate());
    }
}
