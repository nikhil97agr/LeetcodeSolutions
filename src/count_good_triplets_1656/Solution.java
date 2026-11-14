package count_good_triplets_1656;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int x = arr[i];
                    int y = arr[j];
                    int z = arr[k];
                    if(Math.abs(x-y) <= a && Math.abs(y-z)<=b && Math.abs(z-x) <= c){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}