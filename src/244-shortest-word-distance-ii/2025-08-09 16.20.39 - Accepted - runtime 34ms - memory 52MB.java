class WordDistance {
    Map<String, TreeSet<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            map.computeIfAbsent(wordsDict[i], x -> new TreeSet<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        TreeSet<Integer> t1 = map.get(word1);
        TreeSet<Integer> t2 = map.get(word2);
        int ans = 100000;
        for(int ind : t1){
            Integer higher = t2.ceiling(ind);
            Integer lower = t2.floor(ind);

            if(higher != null){
                ans = Math.min(ans, Math.abs(higher - ind));
            }

            if(lower != null){
                ans = Math.min(ans, Math.abs(lower - ind));
            }
        }

        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */