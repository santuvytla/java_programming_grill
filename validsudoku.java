import java.util.HashSet;

public class validsudoku {
    /*
    check valid sudoku for the filled sudoku
     */
    public static void main(String[] args) {


        char board[][] = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(!isValid(board,i,j)){
                    System.out.print(false);
                }
            }
        }
        System.out.print(true);

    }

    private static boolean isValid(char[][] board, int a, int b) {

        HashSet<Character> contained = new HashSet<Character>();
        // cache the occurrence and return false in case of a duplicate
        for (int i = 0; i < 9; i++) {
            if (contained.contains(board[a][i])) {
                return false;
            }
            if (board[a][i] > '0' && board[a][i] <= '9') {
                contained.add(board[a][i]);
            }
        }



        contained.clear();
        for (int i = 0; i < 9; i++) {
            if (contained.contains(board[i][b])) {
                return false;
            }
            if (board[i][b] > '0' && board[i][b] <= '9') {
                contained.add(board[i][b]);
            }
        }

        // Check sub-box board[a][b] located.
        contained.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = a / 3 * 3 + i, y = b / 3 * 3 + j;
                if (contained.contains(board[x][y])) {
                    return false;
                }

                if (board[x][y] > '0' && board[x][y] <= '9') {
                    contained.add(board[x][y]);
                }
            }
        }
        return true;

    }


}

