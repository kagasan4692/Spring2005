package xogame;


import java.util.Scanner;

public class XOGame {
    FieldXO gameField;
    Scanner scanner = new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;

    void setupNewGame() {
        System.out.println("создать новую игру...");
        this.gameField = new FieldXO();
        this.gameField.initField();
    }

    public void play() {
        this.setupNewGame();
        System.out.println("Кто пойдет первый?");
        String next = this.scanner.next();
        char first = next.charAt(0);
        if (first == 'X' || first == 'O') {
            this.whoMakeNextTurn = first;
        } else {
            System.out.println("Разрешается только X или O");
            this.whoMakeNextTurn = 'X';
        }

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
            System.out.println(" Не корректный ввод...");
            System.out.println("Сделай ход заного...");
            turn();
        }

        return rowIndex;
    }
}
