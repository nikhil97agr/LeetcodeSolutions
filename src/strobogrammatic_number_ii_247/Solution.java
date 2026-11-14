package strobogrammatic_number_ii_247;

import java.util.*;
class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Integer, Integer> map = Map.of(
            0, 0,
            1, 1,
            6, 9,
            8, 8,
            9, 6
        );

        Set<String> list = new HashSet<>();

        StringBuilder sb = new StringBuilder(" ".repeat(n));

        solve(list, sb, 0, n-1, map);
        return new ArrayList<>(list);
    }

    private void solve(Set<String> list, StringBuilder sb, int start, int end, Map<Integer, Integer> map){
        if(start > end){
            list.add(sb.toString());
            return;
        }

        if(start == end){
            for(int key : map.keySet()){
                if(start == end && (key == 6 || key == 9)) continue;
                sb.setCharAt(start, (char)('0' + key));
                list.add(sb.toString());
            }

            return ;
        }

        for(int key : map.keySet()){
            int val = map.get(key);
            if(start ==0 && key ==0) continue;
            sb.setCharAt(start, (char)('0' + key));
            sb.setCharAt(end, (char)('0' + val));


            solve(list, sb, start+1, end -1, map);
        }
    }
}