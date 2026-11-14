class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for(String s : words1) map.merge(s, 1, Integer::sum);
        for(String s : words2) m2.merge(s, 1, Integer::sum);

        int ans = 0;

        for(String s : map.keySet()){
            if(map.get(s) ==1 && m2.getOrDefault(s, 0)== 1) ans++;
        }


        return ans;
    }
}