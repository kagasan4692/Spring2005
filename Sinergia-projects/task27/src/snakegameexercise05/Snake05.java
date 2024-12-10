package snakegameexercise05;

public class Snake05 {
    public char body = 'O';
    public char head = '@';
    public int snakeLength = 3;
    int[][] snakeBody;

    public int[][] initializeSnake(char[][] field) {
        FieldSnake05 fieldSnake = new FieldSnake05();
        int size = fieldSnake.size;

        this.snakeBody = new int[size * size][2];

        int startX = size / 2;
        int startY = size / 2;

        for (int i = 0; i < snakeLength; i++) {
            this.snakeBody[i][0] = startX;
            this.snakeBody[i][1] = startY - i;

            field[startX][startY - i] = body;
        }

        field[this.snakeBody[0][0]][this.snakeBody[0][1]] = head;

        fieldSnake.printfield(field);
        return snakeBody;
    }

}
