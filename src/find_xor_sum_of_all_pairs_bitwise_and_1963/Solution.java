package find_xor_sum_of_all_pairs_bitwise_and_1963;

class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int ans = 0;
        int n = arr1.length;
        int m = arr2.length;
        for(int i=0;i<32;i++){
            int cnta[] = new int[]{0,0};
            int cntb[] = new int[]{0,0};

            for(int x : arr1){
                if((x & (1<<i)) ==0){
                    cnta[0]++;
                }else{
                    cnta[1]++;
                }
            }

            for(int x : arr2){
                if((x & ( 1<<i))==0){
                    cntb[0]++;
                }else{
                    cntb[1]++;
                }
            }

            long total = 1l*cnta[1] * cntb[1];
            if(total%2==1){
                ans |= (1<<i);
            }
        }


        return ans;
    }
}