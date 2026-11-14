package detect_capital_520;

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = false;
        int count = 0;
        char ch[] = word.toCharArray();
        int n = ch.length;
        for(int i=0;i<n;i++){
            if(ch[i]>='A' && ch[i]<='Z'){
                count++;
                if(i==0){
                    first = true;
                }
            }
        }
        if(count==0){
            return true;
        }
        if(count==1 && first){
            return true;
        }
        if(count==n){
            return true;
        }
        return false;
    }
}