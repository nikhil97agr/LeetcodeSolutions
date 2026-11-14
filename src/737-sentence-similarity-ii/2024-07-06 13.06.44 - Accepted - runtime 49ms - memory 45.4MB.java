class Solution {
    public boolean areSentencesSimilarTwo(String[] s1, String[] s2, List<List<String>> similarPairs) {
        if(s1.length != s2.length) return false;
        Map<String, String> parent = new HashMap<>();
        for(List<String> pair : similarPairs){
            parent.put(pair.get(0), pair.get(0));
            parent.put(pair.get(1), pair.get(1));
        }

        for(List<String> pair : similarPairs){
            String p1 = findParent(parent, pair.get(0));
            String p2 = findParent(parent, pair.get(1));
            if(!p1.equals(p2)){
                parent.put(p1, p2);
            }
        }
        for(int i=0;i<s1.length;i++){
            if(s1[i].equals(s2[i])) continue;
            String p1 = findParent(parent, s1[i]);
            String p2 = findParent(parent, s2[i]);

            if(p1== null || p2== null || !p1.equals(p2)) return false;
        }

        return true;
        




    }

    private String findParent(Map<String, String> map, String child){
        if(map.get(child) == null || map.get(child).equals(child)) return map.get(child);

        String parent = map.get(child);
        parent = findParent(map, parent);
        map.put(child, parent);
        return parent;
    }
}