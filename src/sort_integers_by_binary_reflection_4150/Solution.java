package sort_integers_by_binary_reflection_4150;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] sortByReflection(int[] nums) {

        List<int[]> list = new ArrayList<>();

        for(int x : nums){
            list.add(new int[]{x, reflect(x)});
        }

        return list.stream().sorted((x,y) -> {
            if(x[1] == y[1]) return x[0] - y[0];

            return x[1] - y[1];
        }).mapToInt(x -> x[0]).toArray();

    }

    private int reflect(int x){
        String s = Integer.toBinaryString(x);
        s = new StringBuilder(s).reverse().toString();
        
        return Integer.parseInt(s, 2);
    }
}