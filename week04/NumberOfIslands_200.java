public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visitNeighbor(grid, i, j);
                }
            }
        }
        return count;
    }

    int[][] step = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public void visitNeighbor(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < step.length; i++) {
            int newx = x+step[i][0];
            int newy = y+step[i][1];
            if (isValid(grid, newx, newy)) {
                visitNeighbor(grid, newx, newy);
            }
        }
    }

    public boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }
}
