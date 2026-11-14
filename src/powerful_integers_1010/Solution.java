package powerful_integers_1010;

import java.util.*;
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        TreeSet<Integer> list = new TreeSet<>();
        int a =1;
        int b = 1;
        for(int i=0;i<20 && a < bound ;i++){
            if(i!=0){
                a*=x;
            }
             b = 1;
            for(int j=0;j<20 &&  a+b <= bound ;j++){
                if(j!=0){
                    b *= y;
                }

                if(a + b > bound) break;
                list.add((a+b));
            }
        }

        return list.stream().toList();
    }
}