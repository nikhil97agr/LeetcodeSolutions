package three_equal_parts_963;

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int ones = 0;
        int i=0;
        for(i=0;i<n;i++){
            ones += arr[i];
        }
        if(ones ==0){
            return new int[]{0, n-1};
        }

        if(ones%3!=0) return new int[]{-1, -1};

        int req = ones/3;

        for(i=0;i<n;i++){
            if(arr[i] == 1) break;
        }
        int start = i;
        ones = 0;
        for(i=0;i<n;i++){
            ones += arr[i];
            if(ones == req + 1){
                break;
            }
        }
        int mid = i;
        ones = 0;

        for( i=0;i<n;i++){
            ones +=arr[i];
            if(ones == 2 * req + 1)
            break;
        }

        int end = i;
        while(end < n && arr[start] == arr[mid] && arr[mid] == arr[end]){
            start++;
            end++;
            mid++;
        }

        if(end == n){
            return new int[]{start-1, mid};
        }

        return new int[]{-1, -1};
    }
}