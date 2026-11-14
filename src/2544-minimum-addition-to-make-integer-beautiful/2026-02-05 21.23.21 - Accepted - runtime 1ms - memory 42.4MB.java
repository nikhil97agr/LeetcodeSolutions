class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        StringBuilder ans = new StringBuilder();
        long num = n;
        long original = n;
        while(!check(n, target)){
            long dig = num%10;
            ans.append((dig ==0 ? 0: (10 - dig)));
            long x = reverse(ans);
            n = original + x;
            num/=10;
            if(dig !=0){
                num++;
            }
        }

        return reverse(ans);
    }

    private long reverse(StringBuilder x){
        if(x.isEmpty()) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(x.toString());
        sb.reverse();
        return Long.parseLong(sb.toString());
    }

    private boolean check(long val, int target){
        int sum = 0;
        while(val > 0){
            sum += (int)(val%10);
            val/=10;
        }

        return sum <= target;
    }
}