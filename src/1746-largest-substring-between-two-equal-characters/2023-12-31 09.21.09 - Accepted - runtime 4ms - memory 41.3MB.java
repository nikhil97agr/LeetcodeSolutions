class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int n = s.length();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int lastIndex = i;
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)==c){
                    lastIndex = j;
                }
            }

            if(lastIndex !=i){
                ans = Math.max(ans, lastIndex - i -1);
            }
        }
        return ans;
    }
}