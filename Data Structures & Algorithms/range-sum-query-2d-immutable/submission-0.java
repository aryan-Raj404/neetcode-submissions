class NumMatrix {
    public int[][] mat;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length+1;
        int n = matrix[0].length+1;
        mat = new int[m][n];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1] + matrix[i-1][j-1] - mat[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1+1;
        int r2 = row2+1;
        int c1 = col1+1;
        int c2 = col2+1;
        return mat[r2][c2] - mat[r1-1][c2] - mat[r2][c1-1] + mat[r1-1][c1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */