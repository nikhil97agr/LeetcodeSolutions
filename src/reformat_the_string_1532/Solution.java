package reformat_the_string_1532;

import java.util.*;
class Solution {
    public String reformat(String s) {
        List<Character> dig = new ArrayList<>();
        List<Character> letter = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) dig.add(c);
            else letter.add(c);
        }

        if(Math.abs(dig.size() - letter.size()) > 1) return "";

        StringBuilder res = new StringBuilder();

        if(dig.size()> letter.size()){
            for(int i=0;i<letter.size();i++){
                res.append(dig.get(i));
                res.append(letter.get(i));
            }

            res.append(dig.get(dig.size()-1));
        }else{
            for(int i=0;i<dig.size();i++){
                res.append(letter.get(i));
                res.append(dig.get(i));
            }

            if(letter.size() > dig.size()){
                res.append(letter.get(letter.size() - 1));
            }
        }

        return res.toString();
    }
}