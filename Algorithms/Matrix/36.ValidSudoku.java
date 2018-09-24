/*Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
*/

/*Method: use HashSet to respectively determine the rows cols and blocks.*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> block = new HashSet<Character>();
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                /*BlockRow changes every three outer loops, while BlockCol changes every loop.
                So it goes like: 
                aaabbbccc
                aaabbbccc
                aaabbbccc
                dddeeefff
                dddeeefff
                dddeeefff
                ggghhhiii
                ggghhhiii
                ggghhhiii
				*/
                int blockRow = j / 3 + 3 * (i / 3);
                int blockCol = j % 3 + 3 * (i % 3);
                if (board[blockRow][blockCol] != '.' && !block.add(board[blockRow][blockCol])) return false;
            }
        }
    return true;
    } 
}
