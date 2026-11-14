class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int start = bottom;
        int ans = 0;
        Arrays.sort(special);
        for(int i=0;i<special.length;i++){
            ans = Math.max(ans, special[i] - start);
            start = special[i] + 1;
        }
        ans = Math.max(ans, top - start+1);
        return ans;
    }
}