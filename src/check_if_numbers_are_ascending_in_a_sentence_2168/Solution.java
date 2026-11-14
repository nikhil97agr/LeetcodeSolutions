package check_if_numbers_are_ascending_in_a_sentence_2168;

import java.util.*;
import java.util.regex.*;

import java.util.regex.Pattern;
class Solution {
    public boolean areNumbersAscending(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        List<Integer> list = new ArrayList<>();

        for(String s1 : s.split(" ")){
            if(pattern.matcher(s1).matches()){
                list.add(Integer.parseInt(s1));
            }
        }

        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}