package exercise01;

import java.util.Random;

public class Figure {
    private char[][] shape;
    private int x, y;

    public Figure() {
        generateRandomShape();
        this.x = 0;
        this.y = 4;
    }

    private void generateRandomShape() {
        Random random = new Random();
        int type = random.nextInt(2);
        if (type == 0) {
            shape = new char[][]{
                    {'#', '#', '#'}
            };
        } else {
            shape = new char[][]{
                    {'#', '#'},
                    {'#', '#'}
            };
        }
    }

    public char[][] getShape() {
        return shape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft() {
        y--;
    }

    public void moveRight() {
        y++;
    }

    public void moveDown() {
        x++;
    }

    public void moveUp() {
        x--;
    }
}
