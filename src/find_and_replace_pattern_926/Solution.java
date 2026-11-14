package find_and_replace_pattern_926;

import java.util.*;
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<Pair> list = generate(pattern);

        List<String> res = new ArrayList<>();

        for(String s : words){
            List<Pair> l = generate(s);
            char v1[] = new char[255];
            char v2[] = new char[255];

            Arrays.fill(v1, ' ');
            Arrays.fill(v2, ' ');

            if(list.size() != l.size()) continue;
            boolean p = true;
            for(int i=0;i<list.size();i++){
                Pair p1 = list.get(i);
                Pair p2 = l.get(i);

                char c1 = p1.c;
                char c2 = p2.c;
                if(p1.cnt != p2.cnt){
                    p = false;
                    break;
                }
                if(v1[c1] == ' ' && v2[c2] == ' '){
                    v1[c1] = c2;
                    v2[c2] = c1;
                    
                }else if(v1[c1] == ' ' || v2[c2] == ' '){
                    p = false;
                     break;
                }else{
                    if(v1[c1] == c2 && v2[c2] == c1){
                        continue;
                    }

                    p = false;
                    break;
                }
            }

            if(p) res.add(s);
            
        }

        return res;
    }

    private List<Pair> generate(String pattern){
        char ch[] = pattern.toCharArray();
        List<Pair> list = new ArrayList<>();
        int cnt = 0;
        char prev = ch[0];

        for(char c : ch){
            if(prev == c){
                cnt++;
            }else{
                list.add(new Pair(prev, cnt));
                cnt = 1;
                prev = c;
          
            }
        }

        list.add(new Pair(prev, cnt));

        return list;
    }

    class Pair{
        char c;
        int cnt;
        public Pair(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
}