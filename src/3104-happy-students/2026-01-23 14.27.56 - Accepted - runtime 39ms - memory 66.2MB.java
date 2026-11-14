class Solution {
    public int countWays(List<Integer> nums) {
        int ans =0 ;
        int c = 0;
        Collections.sort(nums);

        int i=0;
        int n = nums.size();

        if(nums.get(0) !=0) ans++;
        while(i < n){
            if(c < nums.get(i)){
                c++;

                if(nums.get(i) < c) ans++;
                i++;
            }else{
                c++;

                while(i + 1 < n && c >= nums.get(i+1)){
                    c++;
                    i++;
                }
                i++;
                ans++;
            }
        }

        return ans;
    }
}