package sender_with_largest_word_count_2378;

import java.util.*;
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int n = senders.length;

        for(int i=0;i<n;i++){
            int len = messages[i].split(" ").length;
            map.merge(senders[i], len, Integer::sum);
        }

        String res = "";
        int cnt = 0;
        for(String key : map.keySet()){
            int c=map.get(key);

            if(c > cnt){
                cnt = c;
                res= key;
            }else if(c== cnt && key.compareTo(res) > 0){
                res = key;
            }
        }

        return res;
    }
}