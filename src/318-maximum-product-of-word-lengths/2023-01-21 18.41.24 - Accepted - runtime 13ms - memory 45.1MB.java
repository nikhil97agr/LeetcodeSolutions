class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int checkChars[] = new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            for(char c : words[i].toCharArray()){
                count  |= 1<<(c-'a');
            }
            checkChars[i] = count;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((checkChars[i] & checkChars[j])==0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}