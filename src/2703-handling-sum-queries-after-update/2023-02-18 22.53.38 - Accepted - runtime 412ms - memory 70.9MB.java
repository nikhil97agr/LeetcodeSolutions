class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        BitSet bs = new BitSet(n);
        ArrayList<Long> result = new ArrayList<>();
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += 1l * nums2[i];
            if(nums1[i]==1){
                bs.set(i);
            }
        }

        for(int q[] : queries){
            if(q[0]==1){
                bs.flip(q[1], q[2]+1);
            }else if(q[0]==2){
                sum += 1l*q[1]*bs.cardinality(); 
            }else{
                result.add(sum);
            }
        }
        long[] ans = new long[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}