class Solution {
    public int minimumSeconds(List<List<String>> land) {
        int n = land.size();
        int m = land.get(0).size();

        int time[][] = calculateTime(land, n, m);
        
        boolean vis[][] = new boolean[n][m];
        int di= 0;
        int dj= 0;
        PriorityQueue<Node> que = new PriorityQueue<>((a,b) -> a.t - b.t);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land.get(i).get(j).equals("S")){
                    que.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }else if(land.get(i).get(j).equals("D")){
                    di = i;
                    dj = j;
        time[di][dj] = Integer.MAX_VALUE;

                }else if(land.get(i).get(j).equals("X") || land.get(i).get(j).equals("*")){
                    vis[i][j] = true;
                }
            }
        }


        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.i == di && node.j == dj) return node.t;
            int diff[] = new int[]{0,1,0,-1,0};

            for(int i=0;i<4;i++){
                int ni = node.i + diff[i];
                int nj = node.j + diff[i+1];

                if(ni < 0 || nj < 0 || 
                ni >=n || nj >= m || 
                vis[ni][nj] || (time[ni][nj] !=0 && node.t + 1 >= time[ni][nj])){
                    continue;
                }

                vis[ni][nj] = true;


                que.offer(new Node(ni, nj, node.t + 1));

            }
        }



        return -1;

        
    }

    private int[][] calculateTime(List<List<String>> land, int n, int m){
        PriorityQueue<Node> que = new PriorityQueue<>((a,b) -> a.t - b.t);
        int res[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land.get(i).get(j).equals("*")){
                    que.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
                else if(land.get(i).get(j).equals("X") || land.get(i).get(j).equals("D")){
                    vis[i][j] = true;
                }
            }
        }

        while(!que.isEmpty()){
            Node next = que.poll();
            int diff[] = new int[]{0,1,0,-1,0};

            for(int i=0;i<4;i++){
                int ni = next.i + diff[i];
                int nj = next.j + diff[i+1];

                if(ni <0 || nj < 0 || ni >=n || nj >= m|| vis[ni][nj] ){
                    
                    continue;
                }

                vis[ni][nj] = true;
                res[ni][nj] = next.t + 1;

                que.offer(new Node(ni, nj, next.t + 1));
            }
        }


        return res;
    }

    class Node{
        int i;
        int j;
        int t;

        public Node(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}