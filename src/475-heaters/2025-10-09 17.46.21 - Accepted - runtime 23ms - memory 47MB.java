class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(heaters);

        int ans = 0;

        for(int x : houses){
            int bs = bs(heaters, x);

            ans = Math.max(ans, bs);
        }


        return ans;
    }

    private int bs(int arr[], int x){

        int start = 0;
        int end= arr.length-1;

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;

        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] <= x){
                ans1 = x - arr[mid];
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        start = 0;
        end = arr.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] >= x){
                ans2 = arr[mid] - x;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }


        return Math.min(ans1, ans2);
    }
}