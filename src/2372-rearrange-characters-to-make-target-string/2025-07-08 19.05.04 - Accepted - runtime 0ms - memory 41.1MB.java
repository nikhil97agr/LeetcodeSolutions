class Solution {
    public int rearrangeCharacters(String s, String target) {
        int sCnt[] = new int[26];
        int tCnt[] = new int[26];

        for(char c : s.toCharArray()){
            sCnt[c-'a']++;
        }
        for(char c : target.toCharArray()){
            tCnt[c-'a']++;
        }

        int ans = s.length();
        for(int i=0;i<26;i++){
            if(tCnt[i]!=0 && sCnt[i]==0) return 0;
            
            if(sCnt[i] !=0 && tCnt[i]!=0){
                ans = Math.min(sCnt[i]/tCnt[i], ans);
            }
        }

        return ans;
    }
}