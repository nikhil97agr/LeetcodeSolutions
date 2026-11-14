class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(k==0){
            return s.length();
        }
        return solve(s, k, 0, n-1, n);
    }
    
    public int solve(String s, int k, int start, int end, int n){
        if(end<start){
            return -1;
        }
        if(start==end){
            if(k==1)
            return 1;
            else{
                return 0;
            }
        }
        
        int count[] = new int[255];
        for(int i=start;i<=end;i++){
            count[s.charAt(i)]++;
        }
        
        int pivot = -1;
        for(int i=start;i<=end;i++){
            if(count[s.charAt(i)]<k){
                pivot =i ;
                break;
            }
        }
        if(pivot == -1){
            return end-start+1;
        }
        
        int left = solve(s, k, start, pivot-1, n);
        int right = solve(s, k, pivot+1, end, n);
        return Math.max(right, left);
        
    }
}