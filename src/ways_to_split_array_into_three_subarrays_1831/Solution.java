package ways_to_split_array_into_three_subarrays_1831;

class Solution {
    
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        int ans = 0;

        for(int i=0;i<n-2;i++){
            int l =pre[i];

            int start = i+1;
            int end = n-2;

            int i1 = -1;
            int i2 = -1;

            while(start <= end){
                int mid = (start+end)/2;

                int m = pre[mid] - pre[i];
                int r = pre[n-1] - pre[mid];
                if(m > r){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                    i1 = mid;
                }
            }


            start = i+1;
            end = n-2;

            while(start <= end ){
                int mid = (start + end)/2;
                int m = pre[mid] - pre[i];
                int r = pre[n-1] - pre[mid];

                if(m > r){
                    end = mid - 1;
                }else{
                    if(m < l){
                        start = mid + 1;
                    }else{
                        i2= mid;
                        end = mid - 1;
                    }
                }
            }

            if(i1!=-1 && i2!=-1 && i2 <= i1){
                ans = add(ans, i1 - i2 + 1);
            }
        }


        return ans;
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
}