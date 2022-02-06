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
        this.matrix = new int[M][N];
        this.matrix = matrix;
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
