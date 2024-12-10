import snakegameexercise03.FieldSnake03;
import snakegameexercise03.MoveSnake03;
import snakegameexercise03.Snake03;

import java.util.Scanner;

public class Exercise03 {
    static String direction = "RIGHT"; // Начальное направление

    public static void main(String[] args) {
        FieldSnake03 fieldSnake = new FieldSnake03();
        char[][] field = fieldSnake.initializeField();
        int size = fieldSnake.size;

        Snake03 snake = new Snake03();
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

            MoveSnake03 move = new MoveSnake03();
            snakeBody = move.moveSnake(snakeBody, direction);

            if (isGameOver(snakeBody, size)) {
                System.out.println("Игра окончена! Змейка врезалась.");
                break;
            }

        }

        scanner.close();
    }

    private static boolean isValidDirection(String input) {
        return input.equals("UP") || input.equals("DOWN") || input.equals("LEFT") || input.equals("RIGHT");
    }

    private static boolean isGameOver(int[][] snakeBody, int size) {
        int headX = snakeBody[0][0];
        int headY = snakeBody[0][1];

        return headX < 1 || headX >= (size - 1) || headY < 1 || headY >= (size - 1);

    }
}
