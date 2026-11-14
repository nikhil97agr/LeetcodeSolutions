class Solution {
    int mod = 1_000_000_007;
    public int maxTotalValue(int[] value, int[] decay, int m) {
        var n = value.length;
        long l = 1;
        long h = 0;
        for(var v : value){
            h = Math.max(h, v);
        }

        long ans = h + 1;

        while(l <= h){
            var mid = l + ( h - l)/2;
            if(check(value, decay, mid) <= m){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        long val = 0;
        long token = 0;
        for(int i=0;i<n;i++){
            long v = value[i];
            long d= decay[i];
            if(v >= ans){
                long k = (v - ans)/d + 1;
                token += k;

                long first = v;
                long second = v - (k - 1)*d;
                long sum = k * (first + second)/2;
                val += sum;
            }
        }

        long remaining = m - token;
        if(remaining > 0 && ans > 1){
            val += remaining * (ans - 1);
        }


        return (int)(val %mod);
    }

    private long check(int value[], int decay[], long mid){
        long element = 0;
        for(int i=0;i<value.length;i++){
            if(value[i] >= mid){
                element += (1l * value[i] - mid)/decay[i] + 1;
            }

            if(element > 2_000_000_000l){
                return element;
            }
        }

        return element;
    }

 

    
}