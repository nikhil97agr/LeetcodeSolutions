class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
      int sum=0;
      int n=arr.length;
        for(int i=0;i<arr.length;i++){
          int start=i+1;
          int end=n-i;
          int total=start*end;
          int cnt=(total+1)/2;
          sum=sum+cnt*arr[i];
        }
        return sum;
    }
}