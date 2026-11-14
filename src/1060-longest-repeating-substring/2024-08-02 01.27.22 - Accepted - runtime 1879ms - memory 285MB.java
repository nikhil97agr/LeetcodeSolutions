class Solution {
    public int longestRepeatingSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int len = s.length(); len >= 0; len--) {
            for (int i = 0; i <= s.length() - len; i++) {
                String sub = s.substring(i, i + len);
                if(map.containsKey(sub)){
                    map.put(sub, map.get(sub) + 1);
                } else {
                    map.put(sub, 1);
                }
            }
        }
        int len=0;
        for(Map.Entry<String, Integer> e: map.entrySet()){
            if(e.getValue() > 1){
                if(e.getKey().length() > len){
                    len = e.getKey().length();
                }
            }
        }
        return len;
    }
}