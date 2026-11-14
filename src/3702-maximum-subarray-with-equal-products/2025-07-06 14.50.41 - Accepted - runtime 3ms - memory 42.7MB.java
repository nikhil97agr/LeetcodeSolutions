class Solution {
    public int maxLength(int[] arr) {
        int ans = 1;

        int n = arr.length;

        for(int i=0;i<n;i++){
            long prod = arr[i];
            long gcd = arr[i];
            long lcm = arr[i]; 
            for(int j=i+1;j<n;j++){
                prod *= arr[j];
                gcd = gcd(arr[j], gcd);
                lcm = lcm(arr[j], lcm);
                if(prod > (1l << 33)) break;

                if(prod == lcm *gcd){
                    ans = Math.max(ans, j - i  +1);
                }
            }

        }
        return ans;
    }

    private long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }

    private long gcd(long a, long b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}