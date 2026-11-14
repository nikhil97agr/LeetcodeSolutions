package sell_diminishing_valued_colored_balls_1771;

import java.util.*;
class Solution {
    long mod = (long)1e9 + 7;
    public int maxProfit(int[] inventory, int orders) {
       int ans = 0; 
        Arrays.sort(inventory);
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});

        int prev = inventory[0];
        int cnt = 0;
        for(int x : inventory){
            if(x == prev) cnt++;
            else{
                stack.push(new int[]{prev, cnt});
                cnt = 1;
                prev = x;
            }
        }
        stack.push(new int[]{prev, cnt});
        int next[] = stack.pop();
        while(!stack.isEmpty() && orders > 0){
            int p[] = stack.peek();

            prev= p[0];
            int curr = next[0];
            int c = next[1];
            long total = 1l*(curr - prev)*c;
            if(total <= 1l*orders){
                int cost = calc(prev+1, curr);
                ans = sum(ans, prod(cost, c));
                p[1] += c;
                orders -= (int)total;
            }else{
                int num = orders/c;
                int cost = calc(curr - num + 1,curr);
                ans = sum(ans, prod(cost, c ));;
                int remain = orders%c;
                ans = sum(ans, prod(remain, curr - num));
                break;
            }
            next = stack.pop();

        }
       return ans;
    }

    private int calc(int a, int b){
        if(a > b) return 0;
        int total = b - a+1;
        int add = a+ b;
        if(total%2==0) total/=2;
        else add/=2;

        return prod(total, add);
    }

    private int prod(int a, int b){
        long p = 1l*a*b;

        return (int)(p%mod);
    }

    private int sum(int a, int b){
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
    
}