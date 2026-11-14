package least_operators_to_express_number_1004;

class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        if(x==target) return 0;
        if(x > target){
            int o1 = 2 * target - 1;
            int o2 = (x - target) * 2;

            return Math.min(o1, o2);
        }

        int ans = 0;
        long sub = Integer.MAX_VALUE;
        long num = x;

        while(num < target){
            ans++;
            num*= x;
        }

        long extra = num - target;
        if(extra < target){
            sub = leastOpsExpressTarget(x, (int)extra);
        }
        long newTarget = target - (int)(num/ x);
        long add = leastOpsExpressTarget(x, (int)newTarget)-1;
        return (int)Math.min(sub, add) + ans  + 1;

    }
}