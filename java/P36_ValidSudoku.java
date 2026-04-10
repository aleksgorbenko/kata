// https://neetcode.io/problems/valid-sudoku?list=neetcode150
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class P36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // init Maps and Sets for for rows and cols
        // each will have Integer key as it's index 0-8
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        // String key = (row/3, column/3)
        Map<String, Set<Character>> squares = new HashMap<>();
        // double loop, we will check every character
        // and compare it to all other chars that we alredy have in HashMaps
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;

                String squareKey = (row / 3) + "," + (col / 3);
                // 1. init empty HashSet if no values present
                // 2. check if the char is present in row, col or square
                if (rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) ||
                    cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[row][col])) {
                    return false;
                }

                // store the numbers in all 3 hashsets
                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                squares.get(squareKey).add(board[row][col]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P36_ValidSudoku sol = new P36_ValidSudoku();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(sol.isValidSudoku(board)); // true
    }
}
