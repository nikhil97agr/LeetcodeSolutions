class Solution {
    public long removeZeros(long n) {
        char ch[] = Long.toString(n).toCharArray();
        long ans = 0;
        for(char c : ch){
            int dig = c - '0';
            if(dig!=0){
                ans = ans*10 + dig;
            }
        }

        return ans;
    }
}