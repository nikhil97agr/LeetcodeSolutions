package most_frequent_number_following_key_in_an_array_2312;

class Solution {
    public int mostFrequent(int[] nums, int key) {
        int count[] = new int[1001];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == key){
                count[nums[i+1]]++;
            }
        }
        int ans = 0;
        int cnt = 0;
        for(int i=1;i<1001;i++){
            if(count[i] >cnt){
                cnt = count[i];
                ans = i;
            }
        }
        return ans;
    }
}