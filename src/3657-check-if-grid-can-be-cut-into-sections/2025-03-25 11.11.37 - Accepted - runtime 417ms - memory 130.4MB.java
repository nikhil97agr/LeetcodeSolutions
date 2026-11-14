class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int cnt = 0;
        
        
        for(int r[] : rectangles){
            que.offer(new int[]{r[1], 1});
            que.offer(new int[]{r[3], -1});
        }
        
        int rect = 0;
        
        while(!que.isEmpty()){
            int x[] = que.poll();
            if(x[1] == -1){
                rect--;
                
                if(rect == 0){
                    cnt++;
                }
            }else{
                rect++;
            }
        }
        if(cnt >=3){
            return true;
        }
        for(int r[] : rectangles){
            que.offer(new int[]{r[0], 1});
            que.offer(new int[]{r[2], -1});
        }
        rect = 0;
        cnt = 0;
        while(!que.isEmpty()){
            int x[] = que.poll();
            if(x[1] == -1){
                rect--;
                
                if(rect ==0){
                    cnt++;
                }
            }else{
                rect++;
            }
        }
        
        return cnt >= 3;
        
    }
}