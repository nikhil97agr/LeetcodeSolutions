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