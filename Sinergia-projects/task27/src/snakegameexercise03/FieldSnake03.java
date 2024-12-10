package snakegameexercise03;

import java.util.Random;

public class FieldSnake03 {
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

    public void placeFruits(char[][] field, int fruitCount) {
        Random random = new Random();
        for (int i = 0; i < fruitCount; i++) {
            int x, y;
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            } while (field[x][y] != empty); // Убедиться, что фрукт не размещается на змейке или другом фрукте

            field[x][y] = fruit;
        }
    }
}