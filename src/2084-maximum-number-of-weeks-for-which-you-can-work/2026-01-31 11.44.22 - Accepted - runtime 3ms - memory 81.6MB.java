class Solution {
    public long numberOfWeeks(int[] milestones) {
        long total =0;
        long max = 0;
        for(int x : milestones){
            total += x;
            max = Math.max(max, x);
        }

        if( max > total - max){
            return ((total-max)<<1) + 1;
        }

        return total;
    }
}