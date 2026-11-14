class Solution {
    public String clearStars(String s) {
        char ch[] = s.toCharArray();
        TreeMap<Character, PriorityQueue<Integer>> map = new TreeMap<>();
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(c == '*'){
                ch[i] = ' ';
                if(!map.isEmpty()){
                    c = map.firstKey();
                    int ind = map.get(c).poll();
                    ch[ind] = ' ';
                    if(map.get(c).isEmpty()) map.remove(c);
                }
            }else{
                map.computeIfAbsent(c,c1 -> new PriorityQueue<>(Collections.reverseOrder())).offer(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char c : ch){
            if(c != ' '){
                res.append(c);
            }
        }
        return res.toString();
    }
}