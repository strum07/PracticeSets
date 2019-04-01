package CodeDome;

public class Islands {
    static int rows = 0;
    static int cols = 0;

    public static void main(String[] args) {

        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';

        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';


        System.out.println(numIslands(grid));

        System.out.println("Input Islands:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Number of Islands: ");
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        int islands = 0;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        rows = grid.length;
        cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    markVisited(i, j, visited);
                    islands = islands + 1;
                    doJugaad(i-1, j, grid, visited);
                    doJugaad(i, j+1, grid, visited);
                    doJugaad(i+1, j, grid, visited);
                    doJugaad(i, j-1, grid, visited);
                }
            }
        }
        return islands;
    }

    private static void doJugaad(int i, int j, char[][] grid, boolean[][] visited) {
        if (checkBounds(i, j)) {
            if (grid[i][j] == '1') {
                markVisited(i , j, visited);
                doJugaad(i, j + 1, grid, visited);
                doJugaad(i + 1, j, grid, visited);
            }
        }
    }

    private static boolean checkBounds(int i, int j) {
        return i < rows && j < cols && i>-1 &&j>-1;
    }

    static void markVisited(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
    }
}
