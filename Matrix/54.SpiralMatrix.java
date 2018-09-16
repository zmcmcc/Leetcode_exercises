/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

/*Method:Set for flags to indicate the start and end position of rows and columns, and use four different moves: 
lefttop->righttop,righttop->rightdown, rightdown->leftdown, and leftdown->lefttop to retrieve every element.
After each move, one of the flag will change by 1.*/




class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        
        int rowStart = 0;
        int rowEnd = matrix[0].length - 1;
        int colStart = 0;
        int colEnd = matrix.length - 1;
        
        while (true){
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = rowStart; i <= rowEnd; i++){
                res.add(matrix[colStart][i]);
            }
            colStart ++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = colStart; i <= colEnd; i++){
                res.add(matrix[i][rowEnd]);
            }
            rowEnd --;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = rowEnd; i >= rowStart; i--){
                res.add(matrix[colEnd][i]);
            }
            colEnd --;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int i = colEnd; i >=colStart; i--){
                res.add(matrix[i][rowStart]);
            }
            rowStart ++;
            
        }
        return res;
    }
}