package orderly_queue_935;

import java.util.*;
class Solution {
    public String orderlyQueue(String s, int k) {
              if (k >= 2) {
            char ch []= s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
        StringBuilder sb = new StringBuilder(s);
        String result = s;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            sb.deleteCharAt(0);
            sb.append(c);
            if(result.compareTo(sb.toString())>0){
                result = sb.toString();
            }
        }
        return result;
    }
}