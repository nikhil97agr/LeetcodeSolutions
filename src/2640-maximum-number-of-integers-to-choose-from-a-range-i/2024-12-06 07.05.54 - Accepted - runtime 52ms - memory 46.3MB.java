class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<Integer>();
        for(int x : banned){
            set.add(x);
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)&&(maxSum-i)>=0){
                ans++;
                maxSum -= i;
            }
        }
        return ans;
    }
}