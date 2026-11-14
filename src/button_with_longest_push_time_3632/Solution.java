package button_with_longest_push_time_3632;

class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int prev = 0;
        int max = 0;
        int ans = 0;
        
        for(int i=0;i<events.length;i++){
            int ind = events[i][0];
            int t = events[i][1];
            
            int diff = t - prev;
            
            prev = t;
            
            if(diff > max){
                max = diff;
                ans = ind;
                
            }else if(max == diff){
                ans = Math.min(ind, ans);
            }
            
        }
        return ans;
    }
}