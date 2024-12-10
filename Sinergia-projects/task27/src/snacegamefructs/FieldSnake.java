package snacegamefructs;

import java.util.Random;

public class FieldSnake {
    char[][] field;
    public int size = 20;
    char empty = '.';
    char fruit = 'F';

    public void printfield(char[][] fieldPlusSnake) {
        this.field = fieldPlusSnake;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] initializeField() {
        this.field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = empty;
            }
        }
        return this.field;
    }

    public char[][] placeFruits(char[][] field, int fruitCount) {
        Random random = new Random();
        for (int i = 0; i < fruitCount; i++) {
            int x, y;
            do {
                x = random.nextInt(size - 2) + 1;
                y = random.nextInt(size - 2) +1;

            } while (field[x][y] != empty);

            field[x][y] = fruit;
        }
        return field;
    }
}
