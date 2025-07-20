import java.util.LinkedList;
import java.util.Queue;

class IslandsAndTreasure {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Point3<Integer, Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Point3<>(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point3<Integer, Integer, Integer> p = queue.poll();
            int x = p.getX(), y = p.getY(), z = p.getZ();

            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                continue;
            }

            if (grid[x][y] == Integer.MAX_VALUE || grid[x][y] == 0) {
                queue.add(new Point3<>(x + 1, y, z + 1)); // down
                queue.add(new Point3<>(x - 1, y, z + 1)); // up
                queue.add(new Point3<>(x, y + 1, z + 1)); // right
                queue.add(new Point3<>(x, y - 1, z + 1)); // left
            }

            if (grid[x][y] != 0) {
                grid[x][y] = p.getZ();
            }
        }
    }
}