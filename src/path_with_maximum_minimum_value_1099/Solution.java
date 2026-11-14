package path_with_maximum_minimum_value_1099;

import java.util.*;
class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        PriorityQueue<Node> que = new PriorityQueue<>((n1, n2) -> n2.val - n1.val);

        que.offer(new Node(0, 0, grid[0][0]));

        vis[0][0] = true;

        while(!que.isEmpty()){
            Node node = que.poll();

            if(node.i == m-1 && node.j == n-1) return node.val;

            int dir[] = new int[]{0, 1, 0, -1, 0};

            for(int i=0;i<4;i++){
                int ni = node.i + dir[i];
                int nj = node.j + dir[i+1];

                if(ni >=0 && nj >=0 && ni < m && nj < n && !vis[ni][nj]){
                    que.offer(new Node(ni, nj, Math.min(grid[ni][nj], node.val)));
                    vis[ni][nj] = true;
                }
            }
        }

        return -1;
        
    }

    class Node{
        int i;
        int j;
        int val;

        public Node(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}