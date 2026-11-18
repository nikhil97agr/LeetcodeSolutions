package binary_string_with_substrings_representing_1_to_n_1065;

import java.util.*;
class Solution {
    public boolean queryString(String s, int n) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        int m = s.length();
        for(int i=1;i<=31;i++){
            int start = 0;
            int end = i-1;

            while(end < m){
                int num = getNum(s.toCharArray(), start, end);
                if(num >=1 && num <= n) set.add(num);
                end++;
                start++;
            }
        }

        return  set.size() == n;
    }

    private int getNum(char ch[], int start, int end){
        int num =0;
        int i = 0;
        while(start <= end){
            if(ch[end] == '1'){
                num |= (1<<i);
            }
            i++;
            end--;
        }


        return num;
    }
}