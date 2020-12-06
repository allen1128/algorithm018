public class NumIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    recursiveMark(grid, i, j);
                }
            }
        }
        return count;
    }

    int[][] steps = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void recursiveMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int x = 0; x < steps.length; x++) {
            recursiveMark(grid, i + steps[x][0], j + steps[x][1]);
        }
    }

    public static void main(String[] args) {
        NumIslands_200 ni = new NumIslands_200();
        System.out.print(
                ni.numIslands(new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}})
        );
    }
}
