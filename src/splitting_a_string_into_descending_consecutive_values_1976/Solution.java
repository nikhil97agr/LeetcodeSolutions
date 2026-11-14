package splitting_a_string_into_descending_consecutive_values_1976;

import java.math.*;

import java.math.BigInteger;class Solution {
    public boolean splitString(String s) {
        int n = s.length();
        for(int i=0;i<n-1;i++){
            String sub =s.substring(0, i+1);

            if(check(sub, s, i+1, n)){ 
                return true;
            }
        }

        return false;
    }

    private boolean check(String prev, String s, int i, int n){
        if(i==n){
             return true;
        }

        for(int j=i;j<n;j++){
            String sub = s.substring(i, j+1);

            if(valid(prev, sub)){
                 if(check(sub, s, j+1, n)) return true;
            }
        }

        return false;
    }

    private boolean valid(String s1, String s2){
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);

        return b1.subtract(b2).equals(BigInteger.ONE);
    }
}