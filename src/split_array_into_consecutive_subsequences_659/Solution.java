package split_array_into_consecutive_subsequences_659;

class Solution {
    public boolean isPossible(int[] nums) {
        int cnt[] = new int[20001];
        int endCnt[] = new int[20001];

        for(int x : nums){
            cnt[x+1000]++;
        }

        for(int x : nums){
            int ind = x+1000;
            if(cnt[ind] ==0) continue;


            cnt[ind]--;

            if(ind - 1 >= 0 && endCnt[ind-1] > 0){
                endCnt[ind-1]--;
                endCnt[ind]++;
            }else if(ind + 2 < cnt.length && cnt[ind+1] > 0 && cnt[ind+2] >0){
                cnt[ind+1]--;
                cnt[ind+2]--;
                endCnt[ind+2]++;
            }else{
                return false;
            }
        }

        return true;
    }
}