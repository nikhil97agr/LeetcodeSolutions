package find_the_k_beauty_of_a_number_1430;

class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = ""+num;
        int ans = 0;
        int n = s.length();
        for(int i=0;i+k<=n;i++){
            int x = 0;
            for(int j=i;(j-i)<k;j++){
                x = x*10 + (s.charAt(j) - '0');
            }
            if(x!=0 && num%x ==0){
                ans++;
            }
        }
        return ans;
    }
}