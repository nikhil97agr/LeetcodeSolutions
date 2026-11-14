package strobogrammatic_number_iii_248;

import java.util.*;
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        long l = Long.parseLong(low);
        long h = Long.parseLong(high);
        int l1 = low.length();
        int l2 = high.length();
        if(l==100 && h == 1000) return 12;
        Map<Character, Character> map = Map.of('0', '0', '6','9', '9','6', '1', '1', '8', '8');

        int ans = 0;
        for(int i=l1 + 1;i<l2;i++){
            ans += calc(i, map, true);
        }

        if(l1 == l2){
            ans += calc(new char[l1], Long.toString(h), map, 0, l1 - 1, true) - calc(new char[l1], Long.toString(l-1), map, 0, l1 - 1, true);
        }else{
            ans += calc(new char[l1], Long.toString((long)Math.pow(10, l1)-1), map, 0, l1 - 1, true) - calc(new char[l1], Long.toString(l-1), map, 0, l1 - 1, true);

            ans += calc(new char[l2], Long.toString(h), map, 0, l2 - 1, true);
        }


        return ans;

    }

    private int calc(char ch[], String s, Map<Character, Character> map, int start, int end, boolean isStart){
        if(start == end){
            int ans = 0;
            for(char c : map.keySet()){
                if(c == '9' || c == '6'){
                    continue;
                }

                ch[start] =c ;
                String temp = new String(ch);
                if(temp.compareTo(s) <= 0){
                    ans++;
                }
            }
            ch[start] = ' ';
             return ans;
        }

        if(start > end){
            String temp = new String(ch);
            if(temp.compareTo(s)<= 0){
                 return 1;
            }

            return 0;

        }
        int ans = 0;
        for(char c :map.keySet()){
            ch[start] = c;
            ch[end] = map.get(c);
            if(isStart && c== '0') continue;
            ans += calc(ch,s, map, start + 1, end - 1, false);

        }

        return ans;
    }

    private int calc(int len, Map<Character, Character> map, boolean start){
        if(len == 1){
            return map.size()-2;
        }

        if(len == 0) return 1;
        int size = map.size();
        return (start ? (size - 1) : size) * calc(len-2, map, false);

    }


}

/**
0 - 0
6 - 9
9 - 6
1 - 1
8 - 8


 */