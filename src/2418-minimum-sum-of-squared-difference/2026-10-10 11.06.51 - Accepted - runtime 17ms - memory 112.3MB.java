class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long total = 0;
        int n = nums1.length;
        for(int i=0;i<n;i++){
            long diff = Math.abs(nums1[i] - nums2[i]);
            total += diff*diff;
        }
 

        long diff[] = new long[100001];
        for(int i=0;i<n;i++){
            int d = Math.abs(nums1[i] - nums2[i]);
            diff[d]++;
        }
        long k = k1 + k2;
        for(int i=diff.length -1;i>0 && k > 0;i--){
            long cnt = diff[i];
            if(k < cnt){
                total -= k*i*i;
                total += k*(i-1)*(i-1);
                k=0;
            }else{
                total -= cnt * i *i;
                total += cnt * (i-1)*(i-1);
                diff[i-1] += cnt;
                k-= cnt;
            }
        }

        return total;
    }
}

/**
    1 5 => 4
    4 8 => 4
    6 10 => 4
    12 9 => 3

 */