class Solution {
    class Node{
        String word;
        int level;
        public Node(String word, int level){
            this.word= word;
            this.level = level;
        }
        public String toString(){
            return word+":"+level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();
        List<String> list = new ArrayList();
        if(beginWord.equals(endWord)){
            return 1;
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        for(String s : wordList){
            set.add(s);
        }  
        Queue<Node> q = new LinkedList<Node>();
        Node node = new Node(beginWord, 1);
        q.add(node);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        while(!q.isEmpty()){
            node = q.poll();
            if(node.word.equals(endWord)){
                return node.level;
            }
            int n = node.word.length();
            char ch[] = node.word.toCharArray();
            for(int i=0;i<n;i++){
                for(char c ='a';c<='z';c++){
                    ch[i] = c;
                    String temp = new String(ch);
                    if(set.contains(temp)){
                        q.add(new Node(temp, node.level+1));
                        set.remove(temp);
                    }
                }
                ch[i] = node.word.charAt(i);
            }
        }
        return 0;
        
    }
  
    

}