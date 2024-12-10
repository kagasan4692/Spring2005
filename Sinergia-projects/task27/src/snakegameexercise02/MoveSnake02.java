package snakegameexercise02;

import snacegamefructs.Snake;

public class MoveSnake02 {
    public int[][] moveSnake(int[][] snakeBody, String direction) {
        Snake snake = new Snake();
        char body = snake.body;
        char head = snake.head;
        int snakeLength = snake.snakeLength;
        FieldSnake02 fieldSnake = new FieldSnake02();

        int headX = snakeBody[0][0];
        int headY = snakeBody[0][1];

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

        for (int i = snakeLength - 1; i > 0; i--) {
            snakeBody[i][0] = snakeBody[i - 1][0];
            snakeBody[i][1] = snakeBody[i - 1][1];
        }


        snakeBody[0][0] = headX;
        snakeBody[0][1] = headY;

        char[][] field = fieldSnake.initializeField();
        for (int i = 0; i < snakeLength; i++) {
            field[snakeBody[i][0]][snakeBody[i][1]] = (i == 0) ? head : body;
        }

        fieldSnake.printfield(field);

        return snakeBody;
    }


}
