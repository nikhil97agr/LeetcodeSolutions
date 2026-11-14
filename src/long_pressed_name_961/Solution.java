package long_pressed_name_961;

import java.util.*;
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        List<Pair> list = getCnt(name);

        List<Pair> l2 = getCnt(typed);
        if(list.size()!=l2.size()) return false;

        for(int i=0;i<list.size();i++){
            Pair p1 = list.get(i);
            Pair p2 = l2.get(i);

            if(p1.c != p2.c || p1.cnt > p2.cnt) return false;
        }
        return true;
    }

    public List<Pair> getCnt(String s){
        char ch[] = s.toCharArray();
        int cnt = 0;
        char prev = ch[0];
        List<Pair> list = new ArrayList<>();

        for(char c : ch){
            if(prev == c) cnt++;
            else{
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