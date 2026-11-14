package three_sum_with_multiplicity_959;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;

        int cnt[][] = new int[n+1][101];
        for(int i=n-1;i>=0;i--){
            cnt[i] = cnt[i+1].clone();

            cnt[i][arr[i]]++;
        }
        int ans = 0;


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int req = target - arr[i] - arr[j];

                if(req < 0 || req > 100) continue;

                ans = add(ans, cnt[j+1][req]);
            }
        }


        return ans;

    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = a+b;


        return (int)(sum%mod);
    }
}