class Solution {
    public long maximizeSum(int[] nums, int k) {
        long ans = 0;

        List<int[]> list= new ArrayList<>();

        for(int x : nums){
            list.add(new int[]{x, transform(x)});
        }

        Collections.sort(list, (a,b)->{
            int d1 = a[1] - a[0];
            int d2 = b[1] - b[0];

            return d2 - d1;

        });

        for(var x : list){
            if(x[0] == x[1] || k == 0){

                ans += x[0];
            }else{
                k--;
                ans += x[1];
            }

            
        }

        return ans;
    }

    private int transform(int x){
        int dig[] = new int[10];
        while(x > 0){
            dig[x%10]++;
            x/=10;
        }

        for(int i=9;i>=0;i--){
            while(dig[i]-- > 0){
                x = x * 10 + i;
            }
        }

        return x;
    }
}