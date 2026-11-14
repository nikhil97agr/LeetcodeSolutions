class Solution {
    public int[] sortByAbsoluteValue(int[] nums) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b) -> Math.abs(a) - Math.abs(b));

        for(int x : nums) que.offer(x);

        for(int i=0;i<nums.length;i++){
            nums[i] = que.poll();
        }

        return nums;
    }
}