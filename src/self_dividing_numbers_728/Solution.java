package self_dividing_numbers_728;

import java.util.*;
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        while(left <= right){
            int n = left;
            boolean pos = true;
            while(n  > 0){
                int dig = n%10;
                
                if(dig==0 || left%dig != 0){
                    pos = false;
                    break;
                }
                n/=10;
            }
            if(pos) res.add(left);
            left++;
        } 
        return res;
    }
}