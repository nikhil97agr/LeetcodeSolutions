class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length;
        int lps[][] = new int[n][];

        for(int i=0;i<n;i++){
            lps[i] = lps(groups[i]);
        }

        int i=0;
        for(int j=0;j<n;j++){
            Response response = check(nums, i, groups[j], lps[j]);

            if(!response.res) return false;

            i = response.ind;
        }

        return true;
    }

    class Response{
        boolean res;
        int ind;

        public Response(boolean res, int ind){
            this.res = res;
            this.ind = ind;
        }
    }

    private Response check(int nums[], int i, int arr[], int lps[]){
        int j=0;

        while( i< nums.length){
            if(nums[i] == arr[j]){
                i++;
                j++;
                if(j==arr.length){
                    return new Response(true, i);
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }   

        return new Response(false, i);


    }

    private int[] lps(int arr[]){
        int n = arr.length;

        int lps[] = new int[n];

        int i=1;
        int len = 0;

        while( i < n){
            if(arr[i] == arr[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len ==0){
                    i++;
                }else{
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }
}