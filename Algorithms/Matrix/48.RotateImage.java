/*You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*/

/*Method: First transform the matrix, then reverse every row.
This is for 90 degree rotate, if for like 180 degree rotate, just do it one more time.*/

class Solution {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = i; j < matrix.length; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
        
    }
}