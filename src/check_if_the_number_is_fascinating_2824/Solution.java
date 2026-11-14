package check_if_the_number_is_fascinating_2824;

class Solution {
    public boolean isFascinating(int n) {
        String x = ""+n + (2*n)+(3*n);
        int cnt[] = new int[10];
        for(char c : x.toCharArray()){
            cnt[c-'0']++;
        }
        boolean result = true;
        if(cnt[0]>0){
            return false;
        }
        for(int i=1;i<=9;i++){
            if(cnt[i]!=1){
                return false;
            }
        }
        return true;
    }
}