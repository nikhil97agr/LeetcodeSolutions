class Solution {
    public int findPermutationDifference(String s, String t) {
        int c1[]=  count(s);
        int c2[] = count(t);
        int ans = 0;
        for(int i=0;i<26;i++){
            ans += Math.abs(c1[i] - c2[i]);
        }
        return ans;
    }
    
    private int[] count(String s){
        int cnt[] = new int[26];
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']+=i;
        }
        return cnt;
    }
}