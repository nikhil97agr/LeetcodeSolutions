package diet_plan_performance_1280;

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        int n = calories.length;
        int ans = 0;
        for(int i=0;i<k-1;i++){
            sum +=calories[i];
        }
        int start = 0;
        int end = k-1;
        while(end < n){
            sum+= calories[end];

            if(sum < lower) ans--;
            if(sum > upper) ans++;

            sum -= calories[start];
            start++;
            end++;
        }
        return ans;
    }
}