class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int first = 0;
        int sum =0;
        for(int x : arr){
            sum+=x;
        }
        for(int i=0;i<arr.length-1;i++){
            sum -= arr[i];
            first += arr[i];
            int temp = sum;
            int second = 0;
            for(int j=i+1;j<arr.length-1;j++){
                temp -= arr[j];
                second += arr[j];
                if(first == second && second == temp) return true;
            }
        }
        return false;
    }
}