class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s += s;
        int m1 = 0;
        int m2 = 0;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int i=0;i<n*2;i++){
            if(i%2==0){
                s1.append("01");
            }else{
                s2.append("10");
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<2*n;i++){
            if(s1.charAt(i) != s.charAt(i)) m1++;
            if(s2.charAt(i) != s.charAt(i)) m2++;

            if(i >= n){
                if(s1.charAt(i-n) != s.charAt(i-n)) m1--;
                if(s2.charAt(i-n) != s.charAt(i-n)) m2--;

            }

            if(i >= n-1){
                ans = Math.min(ans, Math.min(m1, m2));
            }
        }

        return ans;
        
    }
}