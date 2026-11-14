import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<String> createGrid(int k) {

        char[][] grid = new char[25][25];
        for (int i = 0; i < 25; i++) {
            Arrays.fill(grid[i], '#');
        }

        for (int b = 0; b < 10; b++) {
            int r = b * 2;
            int c = b * 2;
            grid[r][c] = '.';
            grid[r][c + 1] = '.';
            grid[r + 1][c] = '.';
            grid[r + 1][c + 1] = '.';
        }

        for (int b = 0; b < 9; b++) {
            int r = b * 2;
            int c = b * 2;
            grid[r + 2][c + 1] = '.';
        }

        for (int i = 0; i < 25; i++) {
            grid[i][24] = '.';
        }
        
        for (int b = 0; b < 10; b++) {
            if (((k >> b) & 1) == 1) {
                int r = b * 2;
                int c = b * 2;
                for (int j = c; j <= 24; j++) {
                    grid[r][j] = '.';
                }
            }
        }

        return transform(grid);
    }

    private List<String> transform(char[][] grid) {

        List<String> list = new ArrayList<>();
        for (char[] ch : grid) {
            list.add(new String(ch));
        }
        return list;
    }
}