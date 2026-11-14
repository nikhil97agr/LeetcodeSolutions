package reformat_date_1283;

import java.util.*;
class Solution {
    public String reformatDate(String date) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");


        String st[] = date.split(" ");
        String d = st[0].substring(0, st[0].length()-2);
        return st[2]+"-"+map.get(st[1])+"-"+ (d.length() ==1 ? "0"+d : d);
    }
}