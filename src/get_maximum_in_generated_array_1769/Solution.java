package get_maximum_in_generated_array_1769;

class Solution {
    public int getMaximumGenerated(int n) {

        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        int res[] = new int[n+1];

        res[0] = 0;
        res[1] = 1;

        for(int i=1;2*i <=n;i++){
            res[2*i] = res[i];
            if(2*i+1 <=n){
                res[2*i + 1] = res[i] + res[i+1];
            }
        }

        int max = 0;
        for(int x : res) max = Math.max(max, x);
        return max;
    }
}