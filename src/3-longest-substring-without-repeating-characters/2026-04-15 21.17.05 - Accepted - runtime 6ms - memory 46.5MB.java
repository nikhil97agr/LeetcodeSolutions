class Solution {
    public int lengthOfLongestSubstring(String s) {
        var ans = 0;
        var ch = s.toCharArray();
        var n = s.length();
        var start=0;
        var end =0;
        var set = new HashSet<Character>();

        while(end < n){
            while(set.contains(ch[end])){
                set.remove(ch[start]);
                start++;
            }

            ans = Math.max(ans, end - start + 1);
            set.add(ch[end]);
            end++;
        }

        return ans;
    }
}