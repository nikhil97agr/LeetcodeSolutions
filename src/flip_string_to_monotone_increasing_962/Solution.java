package flip_string_to_monotone_increasing_962;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c=='1'){
                one++;
            }else if(one>0){
                one--;
                ans++;
            }
        }
        return ans;

    }
}