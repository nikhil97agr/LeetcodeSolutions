class Solution {
    public int minSwaps(String s) {
        int cnt = 0;
        int open = 0;
        for(char c : s.toCharArray()){
            if(c=='['){
                open++;
            }else{
                open = Math.max(open-1, 0);
            }
        }

        return (open+1)/2;
    }
}