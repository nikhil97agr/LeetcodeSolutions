package maximum_score_after_splitting_a_string_1537;

class Solution {
    public int maxScore(String s) {
        int ones = 0;
                int zero = 0;
                        if(s.charAt(0)=='0') zero++;
                                int ans = 0;
                                        for(int i=1;i<s.length();i++){
                                                    if(s.charAt(i)=='1') ones++;
                                                            }
                                                                    ans = zero + ones;
                                                                            for(int i=1;i<s.length()-1;i++){
                                                                                        if(s.charAt(i)=='1'){
                                                                                                        ones--;
                                                                                                                    }else{
                                                                                                                                    zero++;
                                                                                                                                                }
                                                                                                                                                            ans = Math.max(ans, ones + zero);
                                                                                                                                                                    }
                                                                                                                                                                            return ans;
    }
}