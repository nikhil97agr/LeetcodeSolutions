package consecutive_characters_1542;

class Solution {
    public int maxPower(String s) {
        char curr = s.charAt(0);
        int count = 1;
        int ans = 1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==curr)
            {
                count++;
            }
            else
            {
                curr = s.charAt(i);
                ans = Math.max(count, ans);
                count = 1;
            }
        }
        ans = Math.max(count, ans);
        return ans;
    }
}