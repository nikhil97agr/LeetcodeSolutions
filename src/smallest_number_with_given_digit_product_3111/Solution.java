package smallest_number_with_given_digit_product_3111;

import java.util.*;
class Solution {
    public String smallestNumber(long n) {
        if( n < 10){
            return ""+n;
        }
        
        List<Integer> list = new ArrayList<>();

        for(int i=9;i>1;i--){
            while(n%i==0){
                n/=i;
                list.add(i);
            }
        }

        if(n >= 10) return "-1";

        StringBuilder res = new StringBuilder();
        for(int x : list) res.append(x);

        return res.reverse().toString();
    }
}