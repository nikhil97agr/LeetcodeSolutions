class Solution {
    long mod = (long) 1e9 + 7;

    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k ==1) return calc(arr);
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        int copy[] = new int[n*2];
        for(int i=0;i<n;i++){
            copy[i] = copy[i+n] = arr[i];
        }

        if(sum <= 0){
            return calc(copy);
        }

        return add(calc(copy), prod(k-2, sum));


    }

    private int calc(int arr[]) {
        int sum = 0;
        int ans = 0;

        for (int x : arr) {
            sum += x;
            sum = Math.max(sum, x);
            ans = Math.max(ans, sum);
            sum = Math.max(sum, 0);
        }
        return ans;
    }

    private int prod(long a, long b) {
        long p = a * b;
        return (int) (p % mod);
    }

    private int add(long a, long b) {
        long sum = a + b;
        return (int) (sum % mod);
    }
}