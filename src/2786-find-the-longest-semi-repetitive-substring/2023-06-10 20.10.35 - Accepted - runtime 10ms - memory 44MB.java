class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int n = s.length();
        boolean found = false;
        while(end<n-1){
            if(s.charAt(end)==s.charAt(end+1)){
                if(found){
                    ans = Math.max(ans, end-start+1);
                    while(start<end){
                        if(s.charAt(start)==s.charAt(start+1)){
                            start++;
                            break;
                        }
                        start++;
                    }
                }else{
                    found = true;
                }
            }
            end++;
        }
        
        ans = Math.max(ans, end-start+1);
        return ans;
    }
}