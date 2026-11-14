class Solution {
    public long findMaximumNumber(long k, int x) {
        long start =0;
        long end = Long.MAX_VALUE;

        long ans =0;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(check(mid, k, x)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;

    }

    private boolean check(long num, long k, int x){
        long cnt = 0;
        
        if(num == 117507151l){
            System.out.println("THIS");
        }
        for(int pos = x-1;pos <= 62;pos+=x){
            long m = (1l<< pos);

            if( m > num) break;

            long total = num - m + 1;
            long sum = (total / (m<<1))*m + Math.min(total%(m<<1), m);

            if(k - cnt < sum) return false;
            cnt += sum;
        }

        return cnt <= k;
    }
}

/**
1 - 0001
2 - 0010
3 - 0011
4 - 0100
5 - 0101
6 - 0110
7 - 0111
8 - 1000
9 - 1001
10- 1010
11- 1011
12- 1100
13- 1101
14- 1110
15- 1111


 */