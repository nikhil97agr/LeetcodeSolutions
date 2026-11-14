class Solution {
    public int minTimeToType(String word) {
        char curr = 'a';
        int ans = 0;
        for(char ch : word.toCharArray()){
            int first = Math.abs(curr - ch);
            int second = (curr - 'a') + ('z' - ch + 1);
            int third = ('z' - curr) + (ch - 'a' + 1);

             ans += 1 + Math.min(first, Math.min(second, third));
            curr = ch;
        }

        return ans;
    }
}