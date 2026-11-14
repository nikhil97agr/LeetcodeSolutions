class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int count = 0;
        int ans = -1;
        int maxCount = -1;
        int prev = -1;
        for(int i=0;i<n;i++){
            if(arr[i] == prev){
                count++;
            }
            else{
                if(count > maxCount){
                    ans = prev;
                    maxCount = count;
                }
                count = 1;
                prev = arr[i];
                
            }
            
            
        }
        
        if(count > maxCount) ans = prev;
        return ans;
    }
}