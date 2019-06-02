package map;

public class SurroundedRegion {
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        //以边界节点为根执行dfs，符合条件的O标记为F
        for (int i = 0; i < board[0].length; i++) {
            //遍历上边
            dfs(board, 0, i);
        }
        for (int i = 0; i < board[0].length; i++) {
            //遍历下边
            dfs(board, board.length-1, i);
        }
        for (int i = 1; i < board.length-1; i++) {
            //遍历左边
            dfs(board, i, 0);
        }
        for (int i = 1; i < board.length-1; i++) {
            //遍历右边
            dfs(board, i, board[0].length-1);
        }

        //处理标记节点和其他节点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return;
        }
        if (board[x][y] == 'X' || board[x][y] == 'F') {
            //无需处理或者已经处理过
            return;
        } else {
            board[x][y] = 'F';
        }

        //处理邻居
        dfs(board, x - 1, y);
        dfs(board, x, y-1);
        dfs(board, x+1, y);
        dfs(board, x, y+1);
    }

    public static void main(String[] args) {
        SurroundedRegion sr = new SurroundedRegion();

        char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        sr.solve(board);
    }
}
