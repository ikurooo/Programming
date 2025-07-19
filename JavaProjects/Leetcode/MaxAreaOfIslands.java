import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        Set<Point<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !set.contains(new Point<>(i, j))) {
                    ans = Math.max(bfs(set, new Point<>(i, j), grid), ans);
                }
            }
        }
        return ans;
    }

    public int bfs(Set<Point<Integer, Integer>> set, Point<Integer, Integer> point, int[][] grid) {
        Queue<Point<Integer, Integer>> queue = new LinkedList<>();
        queue.add(point);
        int ans = 0;

        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point.x;
            int y = point.y;

            if (x < 0 || y < 0
                    || x >= grid.length || y >= grid[0].length
                    || grid[x][y] == 0 || set.contains(point)) {
                continue;
            }

            set.add(point);
            ans++;

            queue.add(new Point<>(x + 1, y)); // down
            queue.add(new Point<>(x - 1, y)); // up
            queue.add(new Point<>(x, y + 1)); // right
            queue.add(new Point<>(x, y - 1)); // left
        }

        return ans;
    }
}