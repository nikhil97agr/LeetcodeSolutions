package palindrome_permutation_266;

class Solution {
    public boolean canPermutePalindrome(String s) {
        int cnt[] =new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;

        int odd = 0;
        for(int i=0;i<26;i++){
            if(cnt[i]%2==1) odd++;
        }

        return odd < 2;
    }
}