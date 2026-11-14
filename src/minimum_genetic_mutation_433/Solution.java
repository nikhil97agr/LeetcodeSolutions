package minimum_genetic_mutation_433;

import java.util.*;
class Solution {
    class Node{
        String val;
        int level;
        public Node(String val){
            this.val = val;
            this.level = 0;
        }
    }
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet();
        for(String s : bank){
            set.add(s);
        }
        if(!set.contains(end)){
            return -1;
        }
        if(start.equals(end)){
            return 0;
        }
        
        Queue<Node> q = new LinkedList();
        q.add(new Node(start));
        if(set.contains(start)){
            set.remove(start);
        }
        char c[] = new char[]{'A','C','G','T'};
        while(!q.isEmpty()){
            Node node =q.poll();
            if(node.val.equals(end)){
                return node.level;
            }
            char ch[] = node.val.toCharArray();
            for(int i=0;i<ch.length;i++){
                char temp = ch[i];
                for(char x : c){
                    ch[i] = x;
                    String s = new String(ch);
                    if(set.contains(s)){
                        set.remove(s);
                        Node n = new Node(s);
                        n.level = node.level + 1;
                        q.add(n);
                    }
                }
                ch[i] = temp;
            }
        }
        return -1;
    }
}