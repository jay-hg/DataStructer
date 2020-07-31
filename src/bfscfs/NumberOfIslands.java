package bfscfs;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandNum++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandNum;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
        }
    }
}
