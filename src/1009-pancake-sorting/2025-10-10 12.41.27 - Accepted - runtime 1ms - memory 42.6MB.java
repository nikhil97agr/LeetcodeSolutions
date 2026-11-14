class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int maxIndex = -1;
            int max = 0;
            for(int j=i;j>=0;j--){
                if(arr[j] > max){
                    max = arr[j];
                    maxIndex = j;
                }
            }

            if(maxIndex == i) continue;

            flip(arr, 0, maxIndex);
            result.add(maxIndex +1);
            flip(arr, 0, i);
            result.add(i+1);
        }

        return result;
    }

    private void flip(int arr[], int start, int end){
        while(start <end){
            int val = arr[start];
            arr[start] = arr[end];
            arr[end] = val;
            start++;
            end--;
        }

    }
}