package snacegamefructs;

import java.util.Scanner;

public class Exercise04 {
    static String direction = "RIGHT";
    static int fruitCount = 5;

    public static void main(String[] args) {
        FieldSnake fieldSnake = new FieldSnake();
        char[][] field = fieldSnake.initializeField();
        int size = fieldSnake.size;

        field = fieldSnake.placeFruits(field, fruitCount);

        Snake snake = new Snake();
        int[][] snakeBody = snake.initializeSnake(field);
        int[] snakeLength = {snake.snakeLength};

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

            MoveSnake move = new MoveSnake();
            snakeBody = move.moveSnake(snakeBody, direction, snakeLength, field, fieldSnake);


            if (isGameOver(snakeBody, size)) {
                System.out.println("Игра окончена! Змейка врезалась.");
                break;
            }

            if (checkWin(field)) {
                System.out.println("Поздравляем! Вы съели все фрукты и победили!");
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

    private static boolean checkWin(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'F'){
                    return false;
                }
            }
        }
        return true;
    }
}
