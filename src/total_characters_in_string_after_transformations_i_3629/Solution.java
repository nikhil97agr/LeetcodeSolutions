package total_characters_in_string_after_transformations_i_3629;

class Solution {
    int mod = (int)1e9+7;
    public int lengthAfterTransformations(String s, int t) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        for(int i=0;i<t;i++){
            int prev = cnt[0];
            for(int j=1;j<26;j++){
                int temp = cnt[j];
                cnt[j] = prev;
                prev = temp;
            }

            cnt[0] = prev;
            cnt[1] = addMod(cnt[1], prev);
        }

        int ans = 0;

        for(int x : cnt){
            ans = addMod(ans, x);
        }
        return ans;
    }

    private int addMod(int a, int b){
        return (a%mod + b%mod) %mod;
    }
}