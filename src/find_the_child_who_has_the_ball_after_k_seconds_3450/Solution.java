package find_the_child_who_has_the_ball_after_k_seconds_3450;

class Solution {
    public int numberOfChild(int n, int k) {
        int curr = 0;
        int dir = 1;
        while(k>0){
            if(curr == n-1){
                dir = -1;
            }else if(curr ==0){
                dir = 1;
            }
            
            k--;
                curr += dir;
        }
        
        return curr;
    }
}