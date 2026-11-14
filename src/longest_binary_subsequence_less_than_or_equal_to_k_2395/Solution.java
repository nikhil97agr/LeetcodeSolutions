package longest_binary_subsequence_less_than_or_equal_to_k_2395;

class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c=='0') cnt++;
        }

        int num = 0;
        int max = s.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            
            if(num + (1<<(max-i))>k) break;

            if(s.charAt(i)=='1'){
                num = num + (1<<(max-i));
            }
            else{
                cnt--;
            }

            ans++;
        }

        return ans + cnt;
    }
}