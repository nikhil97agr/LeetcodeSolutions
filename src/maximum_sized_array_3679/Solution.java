package maximum_sized_array_3679;

class Solution {
    public int maxSizedArray(long s) {
        int ans = 0;
        int start = 1;
        int end = 2000;

        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            long or = 0;
            for (int j = 0; j < mid; j++) {
                for (int k = 0; k < mid; k++) {
                    or += (j | k);
                }
            }

            for(int i=0;i<mid;i++){
                sum += (or*i);
            }

            if (sum > s) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}