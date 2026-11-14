package longest_substring_of_one_repeating_character_2319;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, Integer> range = new TreeMap<>();
        char ch[] =s.toCharArray();
        int n = s.length();
        int k = queryCharacters.length();
        int ans[] = new int[k];
        Stack<Character> stack[] = new Stack[n];

        for(int i=0;i<n;i++){
            stack[i] = new Stack<>();
            stack[i].push(ch[i]);
        }
        for(int i=0;i<k;i++){
            int ind = queryIndices[i];
            char c = queryCharacters.charAt(i);
            ch[ind] = c;
            stack[ind].push(c);
        }
        int cnt = 0;
        char prev = ch[0];
        int start = 0;
        for(int i=0;i<n;i++){
            if(prev == ch[i]){
                cnt++;
            }else{
                prev = ch[i];
                range.put(start, i-1);
                add(cnt, map);
                start = i;
                cnt = 1;
            }
        }
        
        range.put(start,n-1);
        add(cnt, map);
        
        
        for(int i=k-1;i>=0;i--){
            ans[i] = map.lastKey();
            int ind = queryIndices[i];
            char c = queryCharacters.charAt(i);
            stack[ind].pop();
            ch[ind] = stack[ind].peek();
            if(c == stack[ind].peek()){
                continue;
            }
            
            
            start = range.floorKey(ind);
            int end = range.get(start);
            range.remove(start);
            remove(end -start + 1, map);
            int s1 = start;
            int e1 = ind - 1;
            int s2 = ind;
            int e2 = ind;
            int s3 = ind + 1;
            int e3 = end;
            if(ind  != 0 && ch[ind] == ch[ind-1]){
                if(s1 == ind){
                    s1 = range.floorKey(s1);
                    e1 = range.get(s1);
                    range.remove(s1);
                    remove(e1 - s1 + 1, map);
                }
                s2 = s1;
                e2 = ind;
                s1 = -1;
                e1 = -1;
            }

            if(ind + 1 < n && ch[ind] == ch[ind + 1]){
                if(e3 == ind){
                    s3 = range.ceilingKey(ind);
                    e3 = range.get(s3);
                    range.remove(s3);
                    remove(e3 - s3 + 1, map);
                }
                e2 = e3;
                s3 = -1;
                e3 = -1;
            }

            if(s1 !=-1 && s1 <= e1){
                range.put(s1, e1);
                add(e1 -s1 + 1, map);
            }

            if(s3 !=-1 && s3 <= e3){
                range.put(s3, e3);
                add(e3 - s3 + 1, map);
            }

            range.put(s2, e2);
            add(e2 -s2 + 1, map);

        }
        
        
        

        return ans;
    }

    private void add(int val, Map<Integer, Integer> map){
        map.merge(val, 1, Integer::sum);
    }

    private void remove(int val, Map<Integer, Integer> map){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }
}