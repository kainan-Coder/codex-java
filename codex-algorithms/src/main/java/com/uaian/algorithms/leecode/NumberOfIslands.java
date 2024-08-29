package com.uaian.algorithms.leecode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j] && grid[i][j] == '1'){
                    ans++;
                    findAll(grid, visit, i, j, m, n);
                }
            }
        }
        return ans;
    }

    private void findAll(char[][] grid, boolean[][] visit, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visit[i][j] || grid[i][j] == '0'){
            return;
        }

        visit[i][j] = true;
        findAll(grid, visit, i + 1, j, m, n);
        findAll(grid, visit, i - 1, j, m, n);
        findAll(grid, visit, i, j + 1, m, n);
        findAll(grid, visit, i, j - 1, m, n);

    }
}
