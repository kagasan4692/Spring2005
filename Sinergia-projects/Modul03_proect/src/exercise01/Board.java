package exercise01;

public class Board {
    private char[][] grid;
    private int score;

    public Board() {
        grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = '.'; // Пустая клетка
            }
        }
        score = 0;
    }

    public boolean canPlaceFigure(Figure figure) {
        int x = figure.getX();
        int y = figure.getY();

        char[][] shape = figure.getShape();

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == '#') {
                    if (x + i > 9 || y + j < 0 || y + j >= 10 || grid[x + i][y + j] == '#') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void placeFigure(Figure figure) {
        int x = figure.getX();
        int y = figure.getY();
        char[][] shape = figure.getShape();

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == '#') {
                    grid[x + i][y + j] = '#';
                }
            }
        }
    }

    public void clearLines() {
        for (int i = 0; i < 10; i++) {
            boolean fullLine = true;
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == '.') {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                for (int k = i; k > 0; k--) {
                    System.arraycopy(grid[k - 1], 0, grid[k], 0, 10);
                }

                for (int j = 0; j < 10; j++) {
                    grid[0][j] = '.';
                }
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printBoardWithFigure(Figure figure) {
        char[][] tempGrid = new char[10][10];

        for (int i = 0; i < 10; i++) {
            System.arraycopy(grid[i], 0, tempGrid[i], 0, 10);
        }

        char[][] shape = figure.getShape();
        int x = figure.getX();
        int y = figure.getY();

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == '#' && x + i < 10 && y + j >= 0 && y + j < 10) {
                    tempGrid[x + i][y + j] = shape[i][j];
                }
            }
        }

        for (char[] row : tempGrid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
