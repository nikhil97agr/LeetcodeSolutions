class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue();
        PriorityQueue<Integer> right = new PriorityQueue();
        long cost = 0;
        int n = costs.length;
        for(int i=0;i<Math.min(candidates, n);i++){
            left.add(costs[i]);
        }
        for(int i=n-1;i>=Math.max(n-candidates, candidates);i--){
            right.add(costs[i]);
        }
        int j=candidates;
        int last = Math.max(n-candidates, candidates);
        
        int i =0;
        for(i=0;i<k;i++){
            if(j>=last){
                break;
            }
            if(left.peek()<=right.peek()){
                cost += left.poll();
                left.add(costs[j++]);
            }else{
                cost += right.poll();
                right.add(costs[--last]);
            }
        }
        while(i<k){

            if(left.isEmpty()){
                cost += right.poll();
                i++;
                continue;
            }else if(right.isEmpty()){
                cost += left.poll();
                i++;
                continue;
            }
            if(left.peek()<=right.peek()){
                cost += left.poll();
            }else{
                cost += right.poll();
            }
            i++;
        }
        return cost;
    }
}