/*Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

/*Method: Similar to Problem 54.*/


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int [n][n];
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        
        while (true){
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = rowStart; i <= rowEnd; i++){
                res[colStart][i] = num;
                num++;
            }
            colStart ++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = colStart; i <= colEnd; i++){
                res[i][rowEnd] = num;
                num++;
            }
            rowEnd --;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = rowEnd; i >= rowStart; i--){
                res[colEnd][i] = num;
                num++;
            }
            colEnd --;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = colEnd; i >=colStart; i--){
                res[i][rowStart] = num;
                num++;
            }
            rowStart ++;
            
        }
        return res;
    }
}