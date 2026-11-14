class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if(arr[0]==1 && arr[n-1]==n){
            return arr[n-1] + k;
        }

        int count = 1;
        for(int i=0;i<n;i++){
            if(arr[i] == count){
                count++;
            }
            else{
                if(k==1){
                    return count;
                }else{
                    count++;
                    k--;
                    i--;
                }
            }
        }
        return count+k-1;
    }
}