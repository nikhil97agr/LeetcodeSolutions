class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<moveFrom.length;i++){
            int start = moveFrom[i];
            int end = moveTo[i];
            if(set.contains(start)){
                set.remove(start);
                set.add(end);
            }
        }

        return set.stream().sorted().toList();
    }
}