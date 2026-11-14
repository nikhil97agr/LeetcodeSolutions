package evaluate_reverse_polish_notation_150;

import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack =new Stack<Integer>();
        for(String s : tokens){
            int a;
            int b;
            switch(s){
                case "+" :
                     a = stack.pop();
                     b = stack.pop();
                    stack.push(a+b);
                 break;
                case "*" : 
                 a = stack.pop();
                     b = stack.pop();
                    stack.push(a*b);
                break;
                case "-" :  a = stack.pop();
                     b = stack.pop();
                    stack.push(b-a);
                    break;
                case "/" :  a = stack.pop();
                     b = stack.pop();
                    stack.push(b/a);
                    break;
                default : stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}