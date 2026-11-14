package fraction_to_recurring_decimal_166;

import java.util.*;
class Solution {
    public String fractionToDecimal(int  n, int d) {
        if(n==0) return "0";

        StringBuilder res = new StringBuilder();

        if((1l*n < 0 && 1l*d >=0) || (1l*n >=0 && 1l*d < 0)) res.append("-");
        long num = Math.abs(1l*n);
        long den = Math.abs(1l*d);
        res.append(num/den);
        num%=den;

        if(num==0) return res.toString();

        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while(num !=0){
            num = num*10;

            res.append(num/den);

            num%=den;
            if(map.containsKey(num)){
                int ind = map.get(num);
                res.insert(ind, "(");
                res.append(")");
                break;
            }else{
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}