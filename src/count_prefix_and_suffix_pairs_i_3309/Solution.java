package count_prefix_and_suffix_pairs_i_3309;

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(solve(words[j], words[i])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private boolean solve(String s1, String s2){
        if(s1.length() > s2.length()) return false;
        if(!s2.startsWith(s1) || !s2.endsWith(s1)){
            return false;
        }
        
        return true;
        
        
    }
}