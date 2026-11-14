class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        if(k==0){
            return 0;
        }
        int start = 0;
        int end = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.merge(c, 1, Integer::sum);

            while(map.size() > k){
                 c = s.charAt(start);
                start++;
                map.merge(c, -1, Integer::sum);
                if(map.get(c) ==0 ){
                    map.remove(c);
                }
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }
}