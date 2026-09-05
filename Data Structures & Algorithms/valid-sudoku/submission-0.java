class Solution {
    public boolean checkRow(int i, int j, char[][] board){
        char ch = board[i][j];
        for(int c=0;c<9;c++){
            if(c!=j && board[i][c] == ch) return false;
        }
        return true;
    }
    public boolean checkCol(int i, int j, char[][] board){
        char ch = board[i][j];
        for(int c=0;c<9;c++){
            if(c!=i && board[c][j] == ch) return false;
        }
        return true;
    }
    public boolean checkBox(int i, int j, char[][] board){
        char ch = board[i][j];
        int rowStart = (int)Math.floor(i/3) * 3;
        int colStart = (int)Math.floor(j/3) * 3;
        int colEnd = colStart + 3;
        int rowEnd = rowStart + 3;
        for(int r=rowStart;r<rowEnd;r++){
            for(int c=colStart;c<colEnd;c++){
                if(r == i && c == j) continue;
                if(board[r][c] == ch) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                if(!checkRow(i, j, board) || !checkCol(i, j, board) || !checkBox(i, j, board)) return false;
            }
        }
        return true;
    }
}
