class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)-> b-a);
        int i=0;
        for( i=0;i<heights.length-1;i++){
            int diff = heights[i+1] - heights[i];
            if(diff <=0 ) continue;
            bricks -= diff;
            que.add(diff);
            if(bricks <0){
                bricks += que.poll();
                ladders--;
            }

            if(ladders < 0){
            
                break;
            }
        }

        return i;
    }
}