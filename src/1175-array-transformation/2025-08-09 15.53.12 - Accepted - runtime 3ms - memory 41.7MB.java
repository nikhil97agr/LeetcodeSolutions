class Solution {
    public List<Integer> transformArray(int[] arr) {
        int n = arr.length;
        while(true){
            boolean change = false;
            int temp[] = arr.clone();
            for(int i=1;i<n-1;i++){
                if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    temp[i]--;
                    change = true;
                }
                else if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                    temp[i]++;
                    change = true;
                }
            }
            arr = temp;
            if(!change){
                break;

            }
        }

        return Arrays.stream(arr).boxed().toList();
    }
}