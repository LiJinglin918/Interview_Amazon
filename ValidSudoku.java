/*
Determine if a Sudoku is valid.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int j = 0; j < 9; j++) {
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.' || !hs.contains(board[i][j])) {
                    hs.add(board[i][j]);
                }
                else 
                    return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.' || !hs.contains(board[i][j]))
                    hs.add(board[i][j]);
                else
                    return false;
            }
        }
        
        int len = 0;
        while (len != 9) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                for (int i = len; i < len + 3; i++) {
                    if (board[i][j] == '.' || !hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else 
                        return false;
                }
            }
            len = len + 3;
        }
        
        len = 0;
        while (len != 9) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 3; j < 6; j++) {
                for (int i = len; i < len + 3; i++) {
                    if (board[i][j] == '.' || !hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else 
                        return false;
                }
            }
            len = len + 3;
        }
        
        len = 0;
        while (len != 9) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 6; j < 9; j++) {
                for (int i = len; i < len + 3; i++) {
                    if (board[i][j] == '.' || !hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else 
                        return false;
                }
            }
            len = len + 3;
        }
        return true;
    }
}

/*===============================================================*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    for (int i=0; i<9; i++) {
        if (!isParticallyValid(board,i,0,i,8)) return false;
        if (!isParticallyValid(board,0,i,8,i)) return false;
    }
    for (int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if (!isParticallyValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
        }
    }
    return true;
}
    private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
        Set singleSet = new HashSet();
        for (int i= x1; i<=x2; i++){
            for (int j=y1;j<=y2; j++){
                if (board[i][j]!='.') if(!singleSet.add(board[i][j])) return false;
            }
        }
        return true;
    }
}
