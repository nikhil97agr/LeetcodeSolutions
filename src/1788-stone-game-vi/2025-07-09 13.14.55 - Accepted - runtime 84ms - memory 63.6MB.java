class Solution {
    public int stoneGameVI(int[] a, int[] b) {
        int n = a.length;

        int arr[][] = new int[n][3];

        for(int i=0;i<n;i++){
            arr[i] = new int[]{a[i], b[i], a[i] + b[i]};
        }

        Arrays.sort(arr, (x,y) -> y[2] - x[2]);

        int sum =0;

        for(int i=0;i<n;i++){
            if(i%2==0) sum += arr[i][0];
            else sum -= arr[i][1];
        }

        return Integer.compare(sum, 0);
    }
}