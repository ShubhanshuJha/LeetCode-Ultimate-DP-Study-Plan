/* Given a 2D matrix matrix, handle multiple queries of the following type:
    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:
    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
    and lower right corner (row2, col2). */


// Bruteforce approach (producing TLE)
class NumMatrix {
    private int[][] matrix = null;
    private int M, N;
    public NumMatrix(int[][] matrix) {
        this.M = matrix.length;
        this.N = matrix[0].length;
        this.matrix = matrix.clone();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += this.matrix[i][j];
            }
        }
        return sum;
    }
}


// Optimized approach (working)
class NumMatrix {
    private int[][] matrix = null;
    private int M, N;
    
    private int[][] dp = null;
    public NumMatrix(int[][] matrix) {
        this.M = matrix.length;
        this.N = matrix[0].length;
        this.matrix = matrix.clone();
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
                dp[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int n = (row2 - row1) + 1;
        int[] ignVal = new int[n];
        int[] sum = new int[n];
        
        for (int i = row1, idx = 0; i <= row2; i++) {
            sum[idx] = this.dp[i][col2];
            if (col1 > 0)
                ignVal[idx] = this.dp[i][col1 - 1];
            idx++;
        }
        for (int i = 0; i < n; i++)
            sum[i] -= ignVal[i];
        
        return (int)Arrays.stream(sum).sum();
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
