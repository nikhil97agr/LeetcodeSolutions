package sentence_similarity_734;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int index = 0;
        Map<Pair, Integer> map = new HashMap<>();

        for(List<String> list : similarPairs){
            String a = list.get(0);
            String b = list.get(1);
            Pair pair = new Pair(a,b);
            if(!map.containsKey(pair)){
                map.put(pair, index);
                index++;
            }
        }

        if(sentence1.length!= sentence2.length){
            return false;
        }

        for(int i=0;i<sentence1.length;i++){
            if(sentence1[i].equals(sentence2[i])) continue;
            Pair pair = new Pair(sentence1[i], sentence2[i]);

            if(!map.containsKey(pair)){
                return false;
            }
        }
        return true;
    }

    class Pair{
        String a;
        String b;

        public Pair(String a, String b){
            if(a.compareTo(b) > 0){
                String temp = b;
                b  = a;
                a = temp;
            }

            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, b);
        }
    }


}