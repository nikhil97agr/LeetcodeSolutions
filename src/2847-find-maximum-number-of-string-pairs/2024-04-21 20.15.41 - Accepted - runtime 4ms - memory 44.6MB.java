class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].length() > 0 && words[j].length() > 0){
                    String reverse = (new StringBuilder(words[j])).reverse().toString();
                    if(words[i].equals(reverse)){
                        words[i] = "";
                        words[j] = "";
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}