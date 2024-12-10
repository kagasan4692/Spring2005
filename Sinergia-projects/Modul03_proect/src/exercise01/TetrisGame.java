package exercise01;

import java.io.*;
import java.util.Scanner;

public class TetrisGame {
    private Board board;
    private int highScore;
    private final String highScoreFile = "highscore.txt";

    public static void main(String[] args) {
        TetrisGame game = new TetrisGame();
        game.start();
    }

    public TetrisGame() {
        board = new Board();
        loadHighScore();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Figure figure = new Figure();

            if (!board.canPlaceFigure(figure)) {
                System.out.println("Игра окончена! Поле заполнено.");
                board.printBoard();
                System.out.println("Ваш финальный счёт: " + board.getScore());
                updateHighScore();
                break;
            }

            while (true) {
                board.printBoardWithFigure(figure);
                System.out.println("Счёт: " + board.getScore());
                System.out.println("Рекорд: " + highScore);
                System.out.println("Управление: 'a' - влево, 'd' - вправо, 's' - вниз (или вызов новой фигуры при достижении дна), 'q' - выход");

                char move = scanner.nextLine().charAt(0);
                if (move == 'a') {
                    figure.moveLeft();
                    if (!board.canPlaceFigure(figure)) figure.moveRight();
                } else if (move == 'd') {
                    figure.moveRight();
                    if (!board.canPlaceFigure(figure)) figure.moveLeft();
                } else if (move == 's') {
                    figure.moveDown();
                    if (!board.canPlaceFigure(figure)) {
                        figure.moveUp();
                        break;
                    }
                } else if (move == 'q') {
                    System.out.println("Вы вышли из игры.");
                    board.printBoard();
                    System.out.println("Ваш финальный счёт: " + board.getScore());
                    updateHighScore();
                    return;
                }
            }

            board.placeFigure(figure);
            board.clearLines();
        }

        updateHighScore();
        System.out.println("Спасибо за игру!");
    }

    private void loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(highScoreFile))) {
            String line = reader.readLine();
            if (line != null) {
                highScore = Integer.parseInt(line);
            } else {
                highScore = 0;
            }
        } catch (IOException | NumberFormatException e) {
            highScore = 0;
        }
    }

    private void updateHighScore() {
        if (board.getScore() > highScore) {
            highScore = board.getScore();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(highScoreFile))) {
                writer.write(String.valueOf(highScore));
            } catch (IOException e) {
                System.out.println("Ошибка сохранения рекорда.");
            }
        }
    }
}