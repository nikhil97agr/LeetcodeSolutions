class Solution {
    public int maxFrequencyScore(int[] nums, int k) {
        int cnt[] = new int[1000001];
        int n = nums.length;
        for(int i=0;i<k;i++){
            cnt[nums[i]]++;
        } 
        int sum = 0;
        for(int i=1;i<=(int)1e6;i++){
            if(cnt[i]!=0){
                sum = add(sum, pow(i, cnt[i]));
            }
        }
        int ans = sum;
        int start = 0;
        int end = k;
        while(end < n){
            int s = nums[start];
            int e = nums[end];
            sum = add(sum, -pow(s, cnt[s]));
            cnt[s]--;
            if(cnt[s]!=0)
            sum = add(sum, pow(s, cnt[s]));

            if(cnt[e]!=0)
            sum = add(sum, -pow(e, cnt[e]));
            cnt[e]++;
            sum = add(sum, pow(e, cnt[e]));
            ans = Math.max( ans, sum);
            start++;
            end++;
        }


        return ans;
    }

    int pow(int a, int b){
        if(a<=1){
            return a;
        }

        if(b==0) return 1;
        int p = pow(a, b/2);

        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }

    int prod(int a, int b){
        long prod = 1l*a*b;
        long mod = (long)1e9 + 7;

        return (int)(prod%mod);
    }

    int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = mod + a + b;

        return (int)(sum%mod);
    }
}