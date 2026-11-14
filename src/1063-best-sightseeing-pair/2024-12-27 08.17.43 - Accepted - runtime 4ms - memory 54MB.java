class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0];
        int ind = 0;
        int ans =0;
        for(int i=1;i<values.length;i++){
            ans = Math.max(ans, max + values[i] + ind - i);

            if(values[i] >= max){
                max = values[i];
                ind = i;
            }else{
                if(max - values[i] <= (i - ind)){
                    max = values[i];
                    ind = i;
                }
            }
        }
        return ans;
    }
}