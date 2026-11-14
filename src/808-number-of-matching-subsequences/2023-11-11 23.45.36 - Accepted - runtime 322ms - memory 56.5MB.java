class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.computeIfAbsent(s.charAt(i), c-> new TreeSet<>()).add(i);
        }
        int count = 0;
        for(String w : words){
            int prev = -1;
            int ind = 0;
            while(ind < w.length()){
                char c = w.charAt(ind);
                if(!map.containsKey(c)) break;
                if(prev==-1){
                    ind++;
                    prev = map.get(c).first();
                }else{
                    Integer index = map.get(c).higher(prev);
                    if(index==null) break;
                    ind++;
                    prev = index;
                }
            }

            if(ind==w.length()) count++;
        }
        return count;
    }
}