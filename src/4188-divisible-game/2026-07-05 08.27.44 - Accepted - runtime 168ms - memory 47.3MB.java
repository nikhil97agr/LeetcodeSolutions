class Solution {
    long mod = 1_000_000_007L;
    public int divisibleGame(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int x : nums){
            if(x == 1){
                continue;
            }

            for(int j=2;j * j <= x;j++){
                if(x%j==0){
                    set.add(j);
                    set.add(x / j);
                }
            }

            set.add(x);
        }

        if(set.isEmpty()){
            set.add(2);
        }

        long ans = Long.MIN_VALUE;
        int k = 2;

        for(var x : set){
            long max = Long.MIN_VALUE;
            long sum = 0;

            for(int num : nums){
                long a = (num%x==0) ? num : -num;
                sum = Math.max(sum + a, a);

                max = Math.max(max, sum);

                
            }

            if(max > ans){
              ans = max;
                k = x;
            }
        }


        return add(prod(k, ans), mod);
        


        
    }

    private int add(long a, long b){
        return (int)((a+b)%mod);
    }

    private int prod(long a, long b){
        long p= 1l * a * b;

        return (int)(p %mod);
    }
}