package number_of_valid_words_for_each_puzzle_1282;

import java.util.*;

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(String s : words){
            int mask = 0;
            for(char c : s.toCharArray()){
                mask |= (1<<c-'a');
            }

            if(Integer.bitCount(mask) <= 7){
                map.merge(mask, 1, Integer::sum);
            }
        }
        for(String p : puzzles){
            int first =(1 << (p.charAt(0) - 'a'));
            int mask = 0;
            for(int i=1;i<p.length();i++){
                mask |= (1 << (p.charAt(i) - 'a'));
            }
            int cnt= 0;
            int subset = mask;
            while(subset > 0){
                int next = subset | first;
                cnt += map.getOrDefault(next, 0);
                subset = (subset -1 ) & mask;
            }
            cnt += map.getOrDefault(subset | first , 0);
            list.add(cnt);
        }

        return list;
    }
}