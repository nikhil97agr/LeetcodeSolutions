class Solution {
    public int reachNumber(int target) {
        int t = Math.abs(target);
        int step = 0;
        int sum =0;
        while(sum < t){
            step++;
            sum += step;
            
        }
        if(sum ==t)return step;

        int diff= sum - t;
        if(diff%2==0) return step ;

        if(step%2==1) return step + 2;
        return step + 1;
    }
}