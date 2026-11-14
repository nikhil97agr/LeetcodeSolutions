class Solution {
    public int minIncrementForUnique(int[] nums) {
        int cnt = 0;
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(nums);
        for(int x : nums){
            if(set.contains(x)){
                int highest = set.getLast();
                cnt+=(highest - x + 1);
                set.add(highest+1);
            }else{
                set.add(x);
            }
        }
        return cnt;
        
    }
}