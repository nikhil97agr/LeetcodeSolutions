class Solution {
    public int minimumDeletions(String s) {

        int a=0;
        int b=0;

        int ans = Integer.MAX_VALUE;

        for(char c : s.toCharArray()){
            if(c=='a') a++;
        }

        for(char c : s.toCharArray()){
            if(c=='a') a--;
            else{
                ans = Math.min(ans, a + b);
                b++;
            }
        }
        ans = Math.min(ans, a+b);

        return ans ;
    }
}