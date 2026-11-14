class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            map.computeIfAbsent(nums[i], x-> new Stack<>()).push(i);   
        }
        for(int i=0;i<n;i++){
            map.get(nums[i]).pop();
            if(map.get(nums[i]).isEmpty()) map.remove(nums[i]);
            int rev= reverse(nums[i]);
            int ind = getNext(map, rev);

            if(ind != -1){
                ans = Math.min(ans, ind - i);
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int val){
        int v = 0;
        while(val > 0){
            int dig =val%10;
            v = v * 10 + dig;
            val/=10;
        }

        return v;
    }

    private int getNext(Map<Integer, Stack<Integer>> map, int val){
        if(!map.containsKey(val)){
            return -1;
        }
        return map.get(val).peek();
    }
}