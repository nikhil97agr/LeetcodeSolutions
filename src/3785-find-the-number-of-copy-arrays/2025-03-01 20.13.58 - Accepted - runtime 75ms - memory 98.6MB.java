class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int interval[][] = new int[n][2];
        
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1] -b[1];
            }

            return a[0] - b[0];
        });

        for(int i=0;i<n;i++){
            que.offer( new int[]{bounds[i][0] - original[i], -1});
            que.offer(new int[]{bounds[i][1] - original[i], 1});
        }

        int count = 0;
        int latest = 0;
        while(!que.isEmpty()){
            int node [] = que.poll();
            if(node[1] == 1){
                if(count!=n){
                    return 0;
                }else{
                    return node[0] - latest + 1;
                }
            }else{
                count++;
                latest = node[0];
            }
        }
        int ans = 0;
        return 0;
    }
}