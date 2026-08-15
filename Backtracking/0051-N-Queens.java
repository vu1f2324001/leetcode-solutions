import java.util.*;

class Solution {
public List<List<String>> solveNQueens(int n) {

List<List<String>> ans = new ArrayList<>();  

    char[][] board = new char[n][n];  

    for (int i = 0; i < n; i++) {  
        Arrays.fill(board[i], '.');  
    }  

    backtrack(0, n, board, ans);  

    return ans;  
}  

void backtrack(int row, int n, char[][] board,  
               List<List<String>> ans) {  

    if (row == n) {  

        List<String> list = new ArrayList<>();  

        for (int i = 0; i < n; i++) {  
            list.add(new String(board[i]));  
        }  

        ans.add(list);  
        return;  
    }  

    for (int col = 0; col < n; col++) {  

        if (isSafe(row, col, n, board)) {  

            board[row][col] = 'Q';  

            backtrack(row + 1, n, board, ans);  

            board[row][col] = '.';  
        }  
    }  
}  

boolean isSafe(int row, int col, int n, char[][] board) {  

      
    for (int i = 0; i < row; i++) {  
        if (board[i][col] == 'Q') {  
            return false;  
        }  
    }  

      
    for (int i = row - 1, j = col - 1;  
         i >= 0 && j >= 0;  
         i--, j--) {  

        if (board[i][j] == 'Q') {  
            return false;  
        }  
    }  

      
    for (int i = row - 1, j = col + 1;  
         i >= 0 && j < n;  
         i--, j++) {  

        if (board[i][j] == 'Q') {  
            return false;  
        }  
    }  

    return true;  
}

}
