package minimum_factorization_625;

class Solution {
    public int smallestFactorization(int num) {
        if(num <= 3) return num;

        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=2;i--){
            while(num%i ==0){
                num/=i;

                sb.append(i);
            }
        }

        if(num >= 2) return 0;

        long ans = Long.parseLong(sb.reverse().toString());

        if(ans > Integer.MAX_VALUE) return 0;
        return (int)ans;

    }
}