package super_pow_372;

import java.util.*;
class Solution {
    public int superPow(int a, int[] b) {
        Queue<Integer> que = new LinkedList<>();

        for(int x : b) que.offer(x);

        return pow(a, que);
    }

    private int pow(int a, Queue<Integer> que){
        if(a==0) return 0;

        if(a==1 ) return 1;
        if(que.isEmpty()) return 1;
        if(que.size() == 1 && que.peek() == 1) return a;

        Queue<Integer>next = new LinkedList<>();
        int carry = 0;
        while(!que.isEmpty()){
            int dig = carry*10 + que.poll();
            int div = dig/2;
            carry = dig%2;
            if(div!=0 || !next.isEmpty()){
                next.offer(div);
            }
        }

        int ans = pow(a, next);

        ans = prod(ans, ans);

        if(carry !=0){
            ans = prod(ans ,a );
        }

        return ans;
    }

    private int prod(int a, int b){
        long ans = 1l*a*b;

        long mod = 1337l;

        return (int)(ans % mod);
    }
}