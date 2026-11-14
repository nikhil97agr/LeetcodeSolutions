package hexadecimal_and_hexatrigesimal_conversion_3912;

import java.util.*;
class Solution {
    Map<Integer, Character> map;
    public String concatHex36(int n) {
        map = new HashMap<>();
        int i = 10;
        for(char c = 'A';c<='Z';c++){
            map.put(i, c);
            i++;
        }
        return hex16(n*n) + hex36(n*n*n);
    }
    private String hex36(int n){
        StringBuilder sb = new StringBuilder();
        while( n > 0){
            int mod = n%36;
            if(mod <= 9){
                sb.append(mod);
            }
            else{
                sb.append(map.get(mod));
            }
            n/=36;
        }

        return sb.reverse().toString();
    }
    private String hex16(int n){
        StringBuilder sb = new StringBuilder();
        while( n > 0){
            int mod = n%16;
            if(mod <= 9){
                sb.append(mod);
            }
            else{
                sb.append(map.get(mod));
            }
            n/=16;
        }

        return sb.reverse().toString();
    }
}