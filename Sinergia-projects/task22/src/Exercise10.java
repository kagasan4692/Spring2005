import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        char size = 3;
        char empty = ' ';
        char playerX = 'X';
        char playerO = 'O';
        StringBuilder board = new StringBuilder("         ");

        Scanner scanner = new Scanner(System.in);
        char currentPlayer = playerX;

        while (true) {
            printBoard(size, board);
            System.out.println("Игрок " + currentPlayer + ", введите ваш ход (строка и столбец от 1 до 3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            int index = row * size + col;

            if (row < 0 || row >= size || col < 0 || col >= size || board.charAt(index) != empty) {
                System.out.println("Этот ход недопустим. Попробуйте еще раз.");
                continue;
            }

            board.setCharAt(index, currentPlayer);

            if (checkWin(currentPlayer, size, board)) {
                printBoard(size, board);
                System.out.println("Игрок " + currentPlayer + " побеждает!");
                break;
            }

            if (isBoardFull(size, empty, board)) {
                printBoard(size, board);
                System.out.println("Игра закончилась вничью!");
                break;
            }

            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }

        scanner.close();
    }

    private static void printBoard(char size, StringBuilder board) {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board.charAt(i * size + j) + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    private static boolean checkWin(char player, char size, StringBuilder board) {
        for (int i = 0; i < size; i++) {
            if ((board.charAt(i * size) == player && board.charAt(i * size + 1) == player && board.charAt(i * size + 2) == player) ||
                    (board.charAt(i) == player && board.charAt(i + size) == player && board.charAt(i + 2 * size) == player)) {
                return true;
            }
        }

        return (board.charAt(0) == player && board.charAt(4) == player && board.charAt(8) == player) ||
                (board.charAt(2) == player && board.charAt(4) == player && board.charAt(6) == player);
    }

    private static boolean isBoardFull(char size, char empty, StringBuilder board) {
        for (int i = 0; i < size * size; i++) {
            if (board.charAt(i) == empty) {
                return false;
            }
        }
        return true;
    }
}
