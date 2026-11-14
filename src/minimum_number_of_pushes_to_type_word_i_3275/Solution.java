package minimum_number_of_pushes_to_type_word_i_3275;

import java.util.*;
class Solution {
    public int minimumPushes(String word) {
      Set<Character> set = new HashSet<>();
        for(char c : word.toCharArray()){
            set.add(c);
        }
        int ans = 0;
        int size  = set.size();
        int click = 1;
        while(size >= 8){
            ans += click*8;
            size -= 8;
            click++;
        }
        ans += click*size;
        return ans;
    }
}