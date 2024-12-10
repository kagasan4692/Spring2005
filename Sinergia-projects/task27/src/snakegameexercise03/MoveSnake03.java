package snakegameexercise03;

public class MoveSnake03 {
    public int[][] moveSnake(int[][] snakeBody, String direction) {
        Snake03 snake = new Snake03();
        char body = snake.body;
        char head = snake.head;
        int snakeLength = snake.snakeLength;

        int headX = snakeBody[0][0];
        int headY = snakeBody[0][1];

        // Рассчитываем новое положение головы
        switch (direction) {
            case "UP":
                headX--;
                break;
            case "DOWN":
                headX++;
                break;
            case "LEFT":
                headY--;
                break;
            case "RIGHT":
                headY++;
                break;
        }

        FieldSnake03 fieldSnake = new FieldSnake03();
        char[][] field = fieldSnake.initializeField();

        // Проверяем, если змейка съела фрукт
        if (field[headX][headY] == 'F') {
            snakeLength++; // Увеличиваем длину змейки
        }

        // Сдвигаем тело змейки
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeBody[i][0] = snakeBody[i - 1][0];
            snakeBody[i][1] = snakeBody[i - 1][1];
        }

        // Устанавливаем новую голову
        snakeBody[0][0] = headX;
        snakeBody[0][1] = headY;

        // Обновляем только змейку на поле
        for (int i = 0; i < snakeLength; i++) {
            field[snakeBody[i][0]][snakeBody[i][1]] = (i == 0) ? head : body;
        }

        fieldSnake.printfield(field);
        return snakeBody;

    }
}
