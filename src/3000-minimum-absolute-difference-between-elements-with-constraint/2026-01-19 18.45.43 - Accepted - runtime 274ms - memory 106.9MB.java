class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        int last = nums.size() - 1;
        for(int i=last;i>=0;i--){
            if(last - i >= x ){
                set.add(nums.get(last));
                last--;
            }
            if(!set.isEmpty()){
                Integer lower = set.ceiling(nums.get(i));
                Integer higher = set.floor(nums.get(i));
                if(lower != null){
                    ans = Math.min(abs(lower, nums.get(i)), ans);
                }
                if(higher != null){
                    ans = Math.min(ans, abs(higher, nums.get(i)));
                }
            }
        }
        last = 0;
        set.clear();
        for(int i=last;i<nums.size();i++){
            if(i-last>= x ){
                set.add(nums.get(last));
                last++;
            }
            if(!set.isEmpty()){
                Integer lower = set.ceiling(nums.get(i));
                Integer higher = set.floor(nums.get(i));
                if(lower != null){
                    ans = Math.min(abs(lower, nums.get(i)), ans);
                }
                if(higher != null){
                    ans = Math.min(ans, abs(higher, nums.get(i)));
                }
            }
        }

        return ans;
    }
    
    private int abs(int a, int b){
        return Math.abs(a-b);
    }

}