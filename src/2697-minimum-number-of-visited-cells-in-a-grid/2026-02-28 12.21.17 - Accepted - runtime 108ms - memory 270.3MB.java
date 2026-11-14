import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> row[] = new PriorityQueue[n];
        PriorityQueue<int[]> col[]  = new PriorityQueue[m];

        for(int i=0;i<n;i++){
            row[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for(int i=0;i<m;i++){
            col[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }

        int dist[][] = new int[n][m];
        for(int d[] : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dist[0][0] = 1;

        row[0].offer(new int[]{dist[0][0], 0, 0, grid[0][0]});
        col[0].offer(new int[]{dist[0][0], 0, 0, grid[0][0]});

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;
                while(!row[i].isEmpty()){
                    int peek[] =row[i].peek();
                    if(peek[3] < j) row[i].poll();
                    else break;
                }

                while(!col[j].isEmpty()){
                    int peek[] = col[j].peek();
                    if(peek[3] < i) col[j].poll();
                    else break;
                }

                int d = dist[i][j];

                if(!row[i].isEmpty()){
                    int peek[] = row[i].peek();
                    d = Math.min(d, peek[0] + 1);
                }
                if(!col[j].isEmpty()){
                    int peek[] = col[j].peek();
                    d = Math.min(d, peek[0] + 1);
                }
                if(d == Integer.MAX_VALUE) continue;

                dist[i][j] = d;

                row[i].offer(new int[]{d, i, j, grid[i][j] + j});
                col[j].offer(new int[]{d, i, j, grid[i][j] + i});

                
            }
        }



        return dist[n-1][m-1] == Integer.MAX_VALUE ? -1 : dist[n-1][m-1];
    }
}