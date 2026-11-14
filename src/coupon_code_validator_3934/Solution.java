package coupon_code_validator_3934;

import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        TreeMap<String, List<String>> map = new TreeMap<>();

        for(int i=0;i<code.length;i++){
            if(isActive[i] && valid(businessLine[i]) && condition(code[i])){
                map.computeIfAbsent(businessLine[i], b-> new ArrayList<>()).add(code[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for(List<String> set : map.values()){
            Collections.sort(set);
            result.addAll(set);
        }

        return result;
    }

    boolean valid(String s){
        return s.equals("electronics") || s.equals("grocery") || s.equals("pharmacy") || s.equals("restaurant");
    }

    boolean condition(String s){
        if(s.length() ==0) return false;

        for(char c : s.toCharArray()){
            if(!((c>='A' && c<='Z') || (c>='a' && c<='z') || (c=='_') || (c>='0' && c<='9'))) return false;
        }
        return true;
    }
}