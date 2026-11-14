class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int prev = lower;
        for(int x : nums){
            if(prev != x){
                result.add(Arrays.asList(prev, x-1));
            }
            prev = x + 1;
        }

        if(prev <= upper){
            result.add(Arrays.asList(prev, upper));

        }

        return result;
    }
}