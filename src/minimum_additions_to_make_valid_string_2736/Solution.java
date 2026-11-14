package minimum_additions_to_make_valid_string_2736;

import java.util.*;
class Solution {
    public int addMinimum(String word) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(char c : word.toCharArray()){
            stack.push(c);
        }

        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c == 'c'){
                if(stack.isEmpty()){
                    ans+=2;
                }else if(stack.size() == 1){
                    if(stack.peek() != 'c'){
                        ans++;
                        stack.pop();
                    }else{
                        ans+=2;
                    }
                }else{
                    char c1 = stack.pop();
                    char c2 = stack.pop();

                    if(c1 == 'b' && c2 == 'a'){
                        continue;
                    }
                    stack.push(c2);
                    if(c1 == 'b' || c1 == 'a'){
                        ans++;
                    }else{
                        stack.push(c1);
                        ans+=2;
                    }
                }
                continue;
            }else if(c == 'b'){
                if(stack.isEmpty()){
                    ans+=2;
                }else{
                    if(stack.peek() == 'a'){
                        ans++;
                        stack.pop();
                    }else{
                        ans+=2;
                    }
                }
            }else{
                ans+=2;

            }
        }

        return ans;
    }
}