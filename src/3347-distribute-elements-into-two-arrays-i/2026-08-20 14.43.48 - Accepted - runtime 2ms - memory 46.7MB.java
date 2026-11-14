class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> l1 =new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int i =0;
        int j=0;
        l1.add(nums[0]);
        l2.add(nums[1]);
        for(int k=2;k<n;k++){
            if(l1.get(i) > l2.get(j)){
                l1.add(nums[k]);
                i++;
            }else{
                l2.add(nums[k]);
                j++;
            }
        }
        int ans[] = new int[n];
        i=0;
        for(int x : l1){
            ans[i++] = x;
        }
        for(int x : l2){
            ans[i++] =x;
        }
        return ans;
    }
}