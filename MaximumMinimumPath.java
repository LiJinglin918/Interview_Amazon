/*
给一个int[][]的matirx，对于一条从左上到右下的path pi，pi中的最小值是mi，求所有mi中的最大值。只能往下或右.
比如：

[8, 4, 7]
[6, 5, 9]
有3条path：
8-4-7-9 min: 4
8-4-5-9 min: 4
8-6-5-9 min: 5
return: 5
*/


// DFS 方法
public class MaximumMinimumPath {
    private int min, max, row, col;
    public int maxMinPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfsHelper(matrix, min, 0, 0);
     return max;
    }

    public void dfsHelper(int[][] matrix, int min, int i, int j ){                
        if (i >= row || j >= col) return;
        if (i == row - 1 && j == col - 1) {
            min = Math.min(min, matrix[i][j]);
            max = Math.max(max, min);
            return;
        }
        min = Math.min(min, matrix[i][j]);
        dfsHelper(matrix, min, i, j + 1);
        dfsHelper(matrix, min, i + 1, j);
    }
}

/*=================================================================================================================*/

// DP 方法
int helper(int[][] matrix){
    int[] result = new int[matrix[0].length];
    result[0] = matrix[0][0];
    for(int i=1; i<matrix[0].length; i++){
        result[i] = Math.min(result[i-1], matrix[0][i]);
    }
    for(int i=1; i<matrix.length; i++){
        result[0] = Math.min(matrix[i][0], result[0]);
        for(int j=1; j<matrix[0].length; j++){
            result[j] = (result[j]<matrix[i][j] && result[j-1]<matrix[i][j])?Math.max(result[j-1], result[j]):matrix[i][j];
            }
        }
        return result[result.length-1];
}

