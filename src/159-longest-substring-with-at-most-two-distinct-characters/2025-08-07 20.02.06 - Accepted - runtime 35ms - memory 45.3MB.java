class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        int start =0;
        int end = 0;
        while(end < s.length()){
            map.merge(s.charAt(end), 1, Integer::sum);

            while(map.size() > 2){
                char c = s.charAt(start);
                map.merge(c, -1, Integer::sum);
                if(map.get(c)==0){
                    map.remove(c);
                }
                start++;
            }

            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }


}