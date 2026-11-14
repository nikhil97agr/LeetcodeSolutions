class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;

        if(n==1) return ""+nums[0];
        if(n==2) return ""+nums[0]+"/"+nums[1];


        StringBuilder res = new StringBuilder("(");
        for(int i=1;i<n;i++){
            res.append(nums[i]);
            if(i!=n-1){
                res.append("/");
            }
        }

        res.append(")");


        return ""+nums[0]+"/"+res.toString();
    }
}