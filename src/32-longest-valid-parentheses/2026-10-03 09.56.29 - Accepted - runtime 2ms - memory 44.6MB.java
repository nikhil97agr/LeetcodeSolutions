class Solution {
    public int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;
        int left= 0;
        int right = 0;
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='(')
            {
                left++;
            }else{
                right++;
            }
            
            if(left==right){
                max = Math.max(max, left+right);
            }
            if(right>left){
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c==')'){
                right++;
            }else{
                left++;
            }
            if(left==right){
                max = Math.max(max, left+right);
            }
            if(left > right){
                left = right= 0 ;
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}