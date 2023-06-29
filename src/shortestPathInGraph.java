import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class shortestPathInGraph {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int sr1 = 0, sc1 = 0, tr1 = 2, tc1 = 0;
        int shortestPath1 = shortestCellPath(grid1, sr1, sc1, tr1, tc1);
        System.out.println("Shortest path length: " + shortestPath1);

        int[][] grid2 = {
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 0, 1, 1}
        };
        int sr2 = 0, sc2 = 0, tr2 = 2, tc2 = 0;
        int shortestPath2 = shortestCellPath(grid2, sr2, sc2, tr2, tc2);
        System.out.println("Shortest path length: " + shortestPath2);
    }
    public static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        int R = grid.length;
        int C = grid[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, 0});

        Set<Integer> visited = new HashSet<>();
        visited.add(sr * C + sc);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int depth = cell[2];

            if (r == tr && c == tc) {
                return depth;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1 && !visited.contains(nr * C + nc)) {
                    queue.offer(new int[]{nr, nc, depth + 1});
                    visited.add(nr * C + nc);
                }
            }
        }

        return -1;
    }
}

