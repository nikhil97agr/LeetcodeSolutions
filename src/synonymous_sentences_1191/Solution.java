package synonymous_sentences_1191;

import java.util.*;
class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : synonyms){
            map.put(list.get(0), list.get(0));
            map.put(list.get(1), list.get(1));
        }

        for(List<String> list: synonyms){
            String a = list.get(0);
            String b = list.get(1);
            String p1 = find(a, map);
            String p2 = find(b, map);

            if(!p1.equals(p2)){
                map.put(p1, p2);
            }
        }

        Map<String, List<String>> par= new HashMap<>();
        for(String key : map.keySet()){
            String p = find(key, map);
            par.computeIfAbsent(p, x -> new ArrayList<>()).add(key);
        }
        List<String> result = new ArrayList<>();
        Queue<Node> que= new LinkedList<>();
        que.offer(new Node(text.split(" "), 0));

        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.ind == node.text.length){
                result.add(String.join(" ", node.text));
                continue;
            }
            String t[]= node.text;
            int ind = node.ind;

            if(!map.containsKey(t[ind])){
                node.ind++;
                que.offer(node);
                continue;
            }

            List<String> list = par.get(find(t[ind], map));

            for(String s : list){
                String tx[] = t.clone();
                tx[ind] = s;
                que.offer(new Node(tx, ind + 1));
            }
        }

        Collections.sort(result);
        return result;
    }

    class Node{
        String text[];
        int ind;
        public Node(String text[], int ind){
            this.text= text;
            this.ind = ind;
        }
    }

    private String find(String p, Map<String,String> map){
        if(map.get(p).equals(p)){
            return p;
        }

        String par = find(map.get(p), map);
        map.put(p, par);
        return par;
    }
}