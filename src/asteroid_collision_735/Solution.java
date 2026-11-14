package asteroid_collision_735;

import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }
            if((stack.peek()>0 && asteroids[i]>0) || (stack.peek()<0 && asteroids[i]<0 )){
                stack.push(asteroids[i]);
                continue;
            }
            if(stack.peek()>0){
                
                if(stack.peek() < Math.abs(asteroids[i])){
                    i--;
                    stack.pop();
                }else if(stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                }
            }else{
                stack.push(asteroids[i]);
            }
        }
        int ans[] = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}