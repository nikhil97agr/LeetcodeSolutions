class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int i =0;
        int j =0;
        int n = nums.length;
        long ans = 0;
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            int min = map.firstKey();
            int max = map.lastKey();
            if(Math.abs(min-max)>2){
                while(i<j){
                    min = map.firstKey();
                    max = map.lastKey();
                    if(Math.abs(min-max)>2){
                        map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                        if(map.get(nums[i])==0){
                            map.remove(nums[i]);
                        }
                    }else{
                        break;
                    }
                    i++;
                }
                long ele = j-i+1;
                long total = (ele*(ele+1))/2l - (ele*(ele-1))/2l;
                ans += total;
            }else{
                
                long ele = j-i+1;
                long total = (ele*(ele+1))/2l - (ele*(ele-1))/2l;
                ans += total;
            }
            j++;
        }
        
        return ans;
        
    }
}