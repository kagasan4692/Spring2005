package snacegamefructs;

public class MoveSnake {

    public int[][] moveSnake(int[][] snakeBody, String direction, int[] snakeLength, char[][] field, FieldSnake fieldSnake) {
        Snake snake = new Snake();
        char body = snake.body;
        char head = snake.head;

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

        if (field[headX][headY] == 'F') {
            snakeLength[0]++;
        }

        for (int i = snakeLength[0]; i > 0; i--) {
            snakeBody[i][0] = snakeBody[i - 1][0];
            snakeBody[i][1] = snakeBody[i - 1][1];
        }

        snakeBody[0][0] = headX;
        snakeBody[0][1] = headY;

        for (int i = 0; i <= snakeLength[0]; i++) {
            if (i == 0) {
                field[snakeBody[i][0]][snakeBody[i][1]]  = head;
            } else if (i == snakeLength[0]) {
                field[snakeBody[i][0]][snakeBody[i][1]] = '.';
            } else {
                field[snakeBody[i][0]][snakeBody[i][1]] = body;
            }

        }

        fieldSnake.printfield(field);

        return snakeBody;
    }


}
