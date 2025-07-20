import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        Set<Point> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !set.contains(new Point(i, j))){
                    bfs(set, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(Set<Point> set, char[][] grid, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));

        int rows = grid.length;
        int cols = grid[0].length;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != '1' || set.contains(point)) {
                continue;
            }

            set.add(point);

            queue.add(new Point(x + 1, y)); // down
            queue.add(new Point(x - 1, y)); // up
            queue.add(new Point(x, y + 1)); // right
            queue.add(new Point(x, y - 1)); // left
        }
    }

}
