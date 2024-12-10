package snakegameexercise02;

import java.util.Scanner;


public class Exercise02 {

    static String direction = "RIGHT"; // Начальное направление

    public static void main(String[] args) {
        FieldSnake02 fieldSnake = new FieldSnake02();
        char[][] field = fieldSnake.initializeField();

        Snake02 snake = new Snake02();
        int[][] snakeBody = snake.initializeSnake(field);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите направление (UP, DOWN, LEFT, RIGHT, или NONE для остановки):");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("NONE")) {
                System.out.println("Игра завершена.");
                break;
            }

            if (isValidDirection(input)) {
                direction = input;
            } else {
                System.out.println("Неверное направление! Попробуйте снова.");
                continue;
            }

            MoveSnake02 move = new MoveSnake02();
            snakeBody = move.moveSnake(snakeBody, direction);

        }

        scanner.close();
    }

    private static boolean isValidDirection(String input) {
        return input.equals("UP") || input.equals("DOWN") || input.equals("LEFT") || input.equals("RIGHT");
    }


}
