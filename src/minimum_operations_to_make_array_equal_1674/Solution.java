package minimum_operations_to_make_array_equal_1674;

class Solution {
    public int minOperations(int n) {

            int ans = 0;
            int mid = n;

            int start = 1;
            int end = 2*(n-1) + 1;
            while(start < end){
                ans += (mid - start);
                start +=2;
                end -= 2;
            }

            return ans;
        


    }
}