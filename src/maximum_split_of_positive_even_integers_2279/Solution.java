package maximum_split_of_positive_even_integers_2279;

import java.util.*;
class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if((finalSum & 1 ) ==1 ) return new ArrayList<>();
        if(finalSum ==0) return new ArrayList<>();
        Stack<Long> stack = new Stack<>();
        long start = 2;
        while(start <= finalSum){
            stack.push(start);
            finalSum -= start;
            start+=2;
        }

        if(finalSum!=0){
            long x = stack.pop();
            stack.push(x + finalSum);
        }
        List<Long> res = new ArrayList<>(stack);
        Collections.reverse(res);
        return res;
    }
}