class Solution {
    public int specialArray(int[] nums) {
        int x = Arrays.stream(nums).max().getAsInt();

        for(int i=1;i<=x;i++){
            int cnt = 0;
            for(int y : nums){
                if(y >= i){
                    cnt++;
                }
            }
            if(cnt ==i) return i;

        }
        return -1;
    }
}