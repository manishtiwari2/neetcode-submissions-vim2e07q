class Solution {

    List<List<String>> result;

    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0},{-1,-1}, {1,1}, {1,-1}, {-1,1}};
    int n;

    public List<List<String>> solveNQueens(int n) {

        this.n = n;
        result = new ArrayList<>();
        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        backtrack(0, grid, new ArrayList<>());

        return result;
    }

    void backtrack(int idx, char[][] grid, List<String> state) {

        if (idx == n) {
            result.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!valid(idx, i, grid)) {
                continue;
            }

            grid[idx][i] = 'Q';

            state.add(new String(grid[idx]));

            backtrack(idx + 1, grid, state);

            state.remove(state.size() - 1);
            grid[idx][i] = '.';
        }
    }

    boolean valid(int r, int c, char[][] grid) {

        for (int[] dir : dirs) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            while (nr >= 0 && nc >= 0 && nr < n && nc < n) {

                if (grid[nr][nc] == 'Q') {
                    return false;
                }

                nr += dir[0];
                nc += dir[1];
            }
        }

        return true;
    }
}