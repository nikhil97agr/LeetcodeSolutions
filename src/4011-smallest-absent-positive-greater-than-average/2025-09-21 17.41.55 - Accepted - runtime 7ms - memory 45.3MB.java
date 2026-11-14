class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            sum +=x;
            set.add(x);
        }
        int avg = sum / n;
        int ans = Math.max(avg + 1, 1);
        while(set.contains(ans)) ans++;
        return ans;
    }
}