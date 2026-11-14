package longest_balanced_substring_i_4055;

class Solution {
    public int longestBalanced(String s) {
       int ans =0 ;
        int n = s.length();
        char arr[] = s.toCharArray();
        for(int i=0;i<n;i++){
            int cnt[] = new int[26];
            for(int j=i;j<n;j++){
                cnt[arr[j]-'a']++;
                if(check(cnt)){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
    private boolean check(int cnt[]){
        int c=0;
        for(int i=0;i<26;i++){
            if(cnt[i] ==0){
                continue;
            }

            if(c==0){
                c = cnt[i];
                continue;
            }

            if(c != cnt[i]) return false;
        }

        return true;
    }
}