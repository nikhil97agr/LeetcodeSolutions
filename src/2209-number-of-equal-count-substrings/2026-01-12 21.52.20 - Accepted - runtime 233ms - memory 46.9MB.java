class Solution {
    public int equalCountSubstrings(String s, int count) {
        int ans = 0;
        char ch[] = s.toCharArray();
        int n = s.length();
        for (int len = count;len <= 26*count && len <= n; len += count) {
            int charCount[] = new int[26];
            Map<Integer, Integer> map = new HashMap<>();
            int start = 0;
            int end = 0;
            while(end < len-1){
                int ind = ch[end] - 'a';
                if(charCount[ind] !=0){
                    remove(map, charCount[ind]);
                }
                charCount[ind]++;
                add(map, charCount[ind]);
                end++;
            }

            while(end < n){
                int ind = ch[end] - 'a';
                if(charCount[ind] !=0){
                    remove(map, charCount[ind]);
                }

                charCount[ind]++;
                add(map, charCount[ind]);
                if(map.size() == 1 && map.containsKey(count)){
                    ans++;
                }
                ind = ch[start] - 'a';
                remove(map, charCount[ind]);
                charCount[ind]--;
                if(charCount[ind] !=0){
                    add(map, charCount[ind]);
                }
                start++;
                end++;
            }
        }
        return ans;
    }

    private void add(Map<Integer, Integer> map, int val) {
        map.merge(val, 1, Integer::sum);
    }

    private void remove(Map<Integer, Integer> map, int val) {
        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0)
            map.remove(val);
    }
}