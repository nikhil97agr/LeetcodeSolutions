class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int start = lower;
        int end = 0;
        while(start <= upper && set.contains(start)){
            start++;
        }

        List<List<Integer>> list = new ArrayList<>();
        while(start <= upper){
            end = start;
            while(end <= upper && !set.contains(end)){
                end++;
            }

            list.add(Arrays.asList(start, end - 1));
            start = end;
            while(start <= upper && set.contains(start)){
                start++;
            }


        }

        return list;
    }
}