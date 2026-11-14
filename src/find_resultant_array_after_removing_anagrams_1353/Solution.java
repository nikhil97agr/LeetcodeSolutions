package find_resultant_array_after_removing_anagrams_1353;

import java.util.*;
class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> stack =new Stack<>();

        for(String s: words){
            if(stack.isEmpty()){
                stack.push(s);
                continue;
            }

            if(!isAnagram(s, stack.peek())){
                stack.push(s);
            }
        }

        List<String> res = new ArrayList<>();

        
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }

    private boolean isAnagram(String a, String b){
        int cnt1[] =build(a);
        int cnt2[] = build(b);

        return Arrays.equals(cnt1, cnt2);

    }

    private int[] build (String s){
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        return cnt;
    }
}