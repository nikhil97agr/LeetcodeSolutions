package lexicographically_smallest_string_after_applying_operations_1747;

import java.util.*;
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set = new HashSet<>();
        String result = s;
        Queue<String> que =new LinkedList<>();
        que.offer(s);
        set.add(s);
        while(!que.isEmpty()){
            s = que.poll();

            if(s.compareTo(result) < 0){
                result = s;
                
            }

            rotate(s, que, set, b);
            sum(s, que, set, a);
        }
 
        return result;
    }

    private void sum(String s, Queue<String> que, Set<String> set, int a){
        char ch[] = s.toCharArray();

        for(int i=1;i<s.length();i+=2){
            int dig = ch[i] - '0';
            dig = (dig + a)%10;
            ch[i] = (char)('0'+dig);
        }
        s= new String(ch);
        if(!set.contains(s)){
            set.add(s);
            que.offer(s);
        }
    }

    private void rotate(String s, Queue<String> que, Set<String> set, int b){
        char ch[] = s.toCharArray();
        char temp[] = new char[s.length()];
        int n = s.length();
        for(int i=0;i<s.length();i++){
            int next = (i+b)%n;
            temp[next] = ch[i];
        }

        s = new String(temp);
        if(!set.contains(s)){
            set.add(s);
            que.offer(s);
        }
    }
}