class Solution {
    public int minUnlockedIndices(int[] nums, int[] locked) {
        
        int n = nums.length;
        if(n==1) return 0;
        int min = 3;
        for(int i=n-1;i>=0;i--){
            if(nums[i] == 3 && min==1) return -1;
            min = Math.min(min,nums[i]);
        }

        int first[] = new int[]{-1,-1};
        int second[] = new int[]{-1,-1};
        for(int i=0;i<n;i++){
            if(nums[i]==2){
                if(first[0]== -1){
                    first[0] = i;
                }
                second[1] = i;
            }

            if(nums[i] ==3 && second[0] == -1){
                second[0] =i;
            }

            if(nums[i] == 1){
                first[1] = i;
            }
        }
        int start = -1;
        int end = -1;
        if((first[0] == -1 || first[1] == -1) && (second[0] == -1 || second[1] == -1)){
            return 0;
        }else if(first[0]== -1 || first[1] == -1){
             start = second[0];
             end = second[1];

        }else if(second[0] == -1 || second[1] == -1){
            start = first[0];
            end = first[1];
        }else{
            int ans = 0;
            if(first[1] < second[0] || second[1] < first[0]){
                for(int i=first[0] ;i<first[1];i++){
                    if(locked[i] == 1)ans++;
                }

                for(int i=second[0];i<second[1];i++){
                    if(locked[i] == 1)ans++;
                }
                return ans;
            }
            start = Math.min(first[0], second[0]);
            end = Math.max(first[1], second[1]);
        }
        int ans = 0;
        for(int i=start;i<end;i++){
            if(locked[i] == 1)ans++;
        }

        return ans;

    }
}