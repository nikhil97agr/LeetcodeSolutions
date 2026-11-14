package earliest_second_to_mark_indices_i_3292;

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        int start =1;
        int end = m;

        int ans = -1;
        while(start <= end){
            int mid = (start+end)/2;

            if(possible(nums.clone(), changeIndices, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid+ 1;
            }
        }

        return ans;
    }

    private boolean possible(int nums[], int change[], int second){
        int i = second - 1;
        int cnt = nums.length;
        int used= 0;
        while(i >= 0 && cnt > 0){
            int ind = change[i] - 1;
            int val = nums[ind];
            if(val == -1){
                i--;
                if(used>0)
                used--;
                else second--;
                continue;
            }

            if(second > val){
                cnt--;
                nums[ind] = -1;
                second -= (val+1);
                used += val;
            }else{
                 return false;
            }

            i--;
        }

        return cnt == 0 ;

        
    }
}