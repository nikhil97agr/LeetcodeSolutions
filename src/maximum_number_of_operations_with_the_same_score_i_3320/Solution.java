package maximum_number_of_operations_with_the_same_score_i_3320;

class Solution {
    public int maxOperations(int[] nums) {
        int size = nums.length;
        if(size%2==1){
            size--;
        }
        int score = nums[0] + nums[1];
        int cnt = 1;
        
        for(int i=2;i<size;i+=2){
            int sum = nums[i] + nums[i+1];
            if(sum == score){
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }
}