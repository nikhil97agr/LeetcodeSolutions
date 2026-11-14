class Solution {
    public static void main(String[] args) {
        new Solution().countSubstrings("aba", "baba");
    }
    public int countSubstrings(String s, String t) {
        int ans = 0;

        int n = s.length();
        int m = t.length();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int len = j-i+1;

                int start = 0;
                int end = len-1;
                while(end < m){
                    boolean pos = check(s, i, j, t, start);
                    if(pos){
                        ans++;
                    }
                    start++;
                    end++;

                }
            }
        }

        return ans;
    }

    private boolean check(String s, int s1, int s2, String t, int i){
        int cnt = 0;
        while(s1 <= s2){
            if(s.charAt(s1)!= t.charAt(i)){
                cnt++;
            }
            s1++;
            i++;
        }

        return cnt == 1;
    }
    
}