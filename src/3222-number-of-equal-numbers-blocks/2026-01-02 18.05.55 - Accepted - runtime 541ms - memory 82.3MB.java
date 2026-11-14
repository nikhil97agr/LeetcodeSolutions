/**
 * Definition for BigArray.
 * class BigArray {
 *     public BigArray(int[] elements);
 *     public int at(long index);
 *     public long size();
 * }
 */
class Solution {
    public int countBlocks(BigArray nums) {
        long length = nums.size();
        int ans= 0 ;
        long ind = 0;
        while(ind < length){
            int curr = nums.at(ind);
            long start = ind;
            long end = length - 1;
            long i = start;
            while(start<=end){
                long mid = (start + end)/2;
                
                int val = nums.at(mid);
                if(val != curr){
                    end = mid - 1;
                }else{
                    i = mid;
                    start = mid + 1;
                }
            }

            ans++;
            ind = i + 1;
        }

        return ans;
    }
}