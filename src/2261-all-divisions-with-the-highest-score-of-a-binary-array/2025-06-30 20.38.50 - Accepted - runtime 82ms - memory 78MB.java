class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        Map<Integer, List<Integer>> map =new HashMap<>();
        int n = nums.length;
        int zeroes[] = prefix(nums, 0);
        int ones[] = prefix(nums, 1);
        int max = 0;
        for(int i=0;i<=n;i++){
            int sum = zeroes[i] + ones[n] - ones[i];
            max = Math.max(max, sum);
            map.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
        }
        return map.get(max);
    }

    private int[] prefix(int nums[], int val){
        int n = nums.length;

        int prefix[] = new int[n+1];

        for(int i=1;i<=n;i++){
            if(nums[i-1] == val){
                prefix[i] = prefix[i-1] + 1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        return prefix;
    }
}