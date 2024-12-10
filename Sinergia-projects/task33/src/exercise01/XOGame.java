package exercise01;


import java.util.Scanner;

public class XOGame {
    FieldXO gameField;
    Scanner scanner = new Scanner(System.in);
    char whoMakeNextTurn = 'X';
    boolean gameOver = false;

    void setupNewGame() {
        System.out.println("создать новую игру...");
        this.gameField = new FieldXO();
        this.gameField.initField();
    }

    public void play() {
        this.setupNewGame();

        while (!gameOver) {
            turn();
            this.gameOver = gameField.isGameOver(this.whoMakeNextTurn);
            if (this.gameOver) {
                System.out.println(this.whoMakeNextTurn + " ты победил!");
            }
            if (this.whoMakeNextTurn == 'X') {
                this.whoMakeNextTurn = 'O';
            } else {
                this.whoMakeNextTurn = 'X';
            }
        }
        System.out.println("Игра закончена!");
    }

    void turn() {
        System.out.println(this.whoMakeNextTurn + ", твой ход...");
        System.out.println("Введи строку");
        int rowIndex = checkIfDigit();

        System.out.println("Введи столбец");
        int colIndex = checkIfDigit();


        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
            this.gameField.printField();
        } else {
            System.out.println("Сделай ход заного...");
            turn();
        }
    }

    int checkIfDigit() {
        char symbol = this.scanner.next().charAt(0);
        int rowIndex = 1;
        if (Character.isDigit(symbol)) {
            int rowNumber = Character.getNumericValue(symbol);
            rowIndex = rowNumber - 1;
        } else {
            RuntimeException exception = new RuntimeException("Неправильный ввод! Ввести нужно число от 1 до 3");
            System.out.println(exception);
            throw exception;
//            turn();
        }

        return rowIndex;
    }
}
