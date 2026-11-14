package count_collisions_on_a_road_2317;

import java.util.*;
class Solution {
    public int countCollisions(String directions) {
        int ans = 0;
        char ch[] =directions.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : ch){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }

            if(c== 'L'){
                if(stack.peek() == 'R'){
                    ans+=2;
                    stack.pop();
                    while(!stack.isEmpty() && stack.peek() =='R'){
                        ans++;
                        stack.pop();
                    }
                    stack.push('S');
                }else if(stack.peek() == 'S'){
                    ans++;
                }else{
                    stack.push(c);
                }
            }else if(c=='R'){
                stack.push('R');
            }else{
                while(!stack.isEmpty() && stack.peek() =='R'){
                    ans++;
                    stack.pop();
                }
                stack.push('S');
            }
        }

        return ans;
    }
}