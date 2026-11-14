package make_the_string_great_1666;

import java.util.*;
class Solution {
    public String makeGood(String s) {
       Stack<Character> stack = new Stack<Character>();
       for(char c : s.toCharArray()){
           if(stack.isEmpty()){
               stack.push(c);
               continue;
           }
           String peek = ""+stack.peek();
           String current = ""+c;
           if(!peek.equals(current)&&peek.equalsIgnoreCase(current)){
               stack.pop();
           }else{
               stack.push(c);
           }
       }

       char []result = new char[stack.size()];
       int i = stack.size();
       while(!stack.isEmpty()){
           result[--i] = stack.pop();
       }
       return new String(result);
    }
}