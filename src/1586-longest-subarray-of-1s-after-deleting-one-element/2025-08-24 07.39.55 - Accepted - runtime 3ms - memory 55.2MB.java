class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length==1){
            return 0;
        }
        
        int count  = 0;
        for(int x : nums){
            if(x==0){
                list.add(count);
                count = 0;
            }else{
                count++;
            }
        }
        list.add(count);
        if(list.size()==1){
            return list.get(0)-1;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size()-1;i++){
            int total = list.get(i)+list.get(i+1);
            max = Math.max(max, total);
        }
        return max;
    }
}