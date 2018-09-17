/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/

/*Method: Foucus on the first row and first column*/


class Solution {
    public void setZeroes(int[][] matrix) {
    	boolean firstRowZero = false; 
        boolean firstColZero = false;

        //Set the '0''s boundary neighbor in row and colmun to 0.
    	for (int i = 0; i < matrix.length; i++){
    		for (int j = 0; j < matrix[0].length; j++){
    			if (matrix[i][j] == 0){
    				if (i == 0) firstRowZero = true;
    				if (j == 0) firstColZero = true;
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}

    	//Set all the numbers in the row of each 0 boundary numbers in the first column, to 0.
    	for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
    	}
        
        //Set all the numbers in the column of each 0 boundary numbers in the first row, to 0.
        for (int j = 1; j < matrix[0].length; j++){
            if (matrix[0][j] == 0){
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
    	}

    	//check if there's already 0s on the first row or column.
    	if (firstRowZero) {
    		for (int j = 0; j < matrix[0].length; j++){
    			matrix[0][j] = 0;
    		}
    	}

    	if (firstColZero) {
    		for (int i = 0; i < matrix.length; i++){
    			matrix[i][0] = 0;
    		}
    	}

    }
}