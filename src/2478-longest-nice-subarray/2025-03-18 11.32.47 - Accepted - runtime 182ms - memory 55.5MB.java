class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        int start =0;
        int end = 0;
        int cnt[] = new int[32];
        int n = nums.length;
        while(end < n){
            addBits(nums[end], cnt);
            boolean allGood = false;
            while(!allGood){
                allGood = true;
                for(int i=0;i<32;i++){
                    if(cnt[i] > 1){
                        allGood = false;
                    }
                }

                if(!allGood){
                    removeBits(nums[start], cnt);
                    start++;
                }
            }


            ans = Math.max(ans, end - start +1 );
            end++;
        }

        return ans;
    }

    private void removeBits(int x, int cnt[]){
        int i=0;
        while(x > 0){
            cnt[i] -= x%2;
            i++;
            x/=2;
        }
    }


    private void addBits(int x, int cnt[]){
        int i=0;
        while(x > 0){
            cnt[i] += x%2;
            i++;
            x/=2;
        }
    }
}