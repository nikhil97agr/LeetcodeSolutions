package total_distance_to_type_a_string_using_one_finger_4170;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalDistance(String s) {
        int ans = 0;

        Map<Character, int[]> map = new HashMap<>();
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for(int i = 0; i < keyboard.length; i++){
            for(int j = 0; j < keyboard[i].length(); j++){
                map.put(keyboard[i].charAt(j), new int[]{i, j});
            }
        }

        int x = map.get('a')[0];
        int y = map.get('a')[1];
        for(char c : s.toCharArray()){
            int next[] = map.get(c);
            ans += Math.abs(x - next[0]) + Math.abs( y - next[1]);
            x = next[0];
             y = next[1];
        }
        
        return ans;
    }
}