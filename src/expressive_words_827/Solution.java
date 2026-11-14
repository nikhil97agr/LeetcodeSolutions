package expressive_words_827;

import java.util.*;
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        List<Pair> list = getCnt(s);
        for(String st : words){
            if(check(list, getCnt(st))) ans++;
        }


        return ans;
    }
    private boolean check(List<Pair> l1, List<Pair> l2){
        if(l1.size() != l2.size() ) return false;

        for(int i=0;i<l1.size();i++){
            if(l1.get(i).c == l2.get(i).c){
                int c1 = l1.get(i).cnt;
                int c2 = l2.get(i).cnt;

                if(c1 == c2 || (c1 > c2 && c1 >=3 )) continue;

                return false;
            }else{
                return false;
            }
        }

        return true;
    }

    private List<Pair> getCnt(String s){
        int cnt = 0;
        List<Pair> list = new ArrayList<>();
        char prev = s.charAt(0);
        int n = s.length();
        for(char c : s.toCharArray()){
            if(c == prev){
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