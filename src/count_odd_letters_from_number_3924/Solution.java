package count_odd_letters_from_number_3924;

import java.util.*;
class Solution {
    public int countOddLetters(int n) {
        Map<Integer, String> map = Map.of(
            1, "one",
            2, "two",
            3, "three",
            4, "four",
            5, "five",
            6, "six",
            7, "seven",
            8, "eight",
            9, "nine",
            0, "zero"
        );

        int ans = 0;
        int cnt[] = new int[26];
        while( n > 0){
            int x = n%10;
            n/=10;
            String s = map.get(x);
            for(char c :s.toCharArray()){
                cnt[c-'a']++;
            }
        }

        for(int x : cnt){
            if(x%2==1){
                ans++;
            }
        }

        return ans;


    }
}