public class FriendCircles_547 {
    public int findCircleNum2(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int i, boolean[] visited) {
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, j, visited);
            }
        }
    }

    public class UnionFind {
        int[] parents;
        int count;
        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            count = n;
        }

        public int find(int x) {
            int root = x;
            while (root != parents[root]) {
                root = parents[root];
            }

            while (x != parents[x]) {
                int i = parents[x];
                parents[x] = root;
                x = i;
            }
            return root;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parents[rootX] = rootY;
            count--;
        }
    }


    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        FriendCircles_547 fc = new FriendCircles_547();
        System.out.print(fc.findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }

}
