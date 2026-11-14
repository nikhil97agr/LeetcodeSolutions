package number_of_equal_numbers_blocks_3222;

// Definition for BigArray.
abstract class BigArray {
    public BigArray(int[] elements) {}
    public abstract int at(long index);
    public abstract long size();
}
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