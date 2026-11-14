package replace_non_coprime_numbers_in_array_2307;

import java.util.*;
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty()){
                stack.push(1L*nums[i]);
                continue;
            }

            long curr = nums[i];
            long gcd = gcd(nums[i], stack.peek());
            while(!stack.isEmpty() && gcd > 1){
                long x = stack.pop();
                long lcm = (x*curr)/gcd;
                curr = lcm;
                if(stack.isEmpty()){
                    break;
                }
                gcd = gcd(curr, stack.peek());
            }
            stack.push(curr);
        }

        List<Integer> res= new ArrayList<>(stack.size());
        while(!stack.isEmpty()){
            long x = stack.pop();
            res.add((int)x);
        }
        Collections.reverse(res);
        return res;
    }

    private long gcd(long x, long y){
        if(x ==0) return y;

        return gcd(y%x, x);
    }
}