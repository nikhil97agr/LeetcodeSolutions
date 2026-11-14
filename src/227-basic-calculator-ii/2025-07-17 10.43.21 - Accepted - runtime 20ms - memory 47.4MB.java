class Solution {
    public int calculate(String s) {
        char prev = '+';

        int num  = 0;

        Stack<Integer> stack = new Stack<>();


        for(char c : s.toCharArray()){
            if(c == ' ') continue;

            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
                continue;
            }

            if(prev == '+'){
                stack.push(num);
            }else if(prev == '-'){
                stack.push(-num);
            }else if(prev == '*'){
                stack.push(stack.pop()*num);
            }else{
                stack.push(stack.pop()/num);
            }
            num = 0;
            prev = c;
        }

        if(prev == '-'){
            stack.push(-num);
        }else if(prev == '+'){
            stack.push(num);
        }else if(prev == '*'){
            stack.push(stack.pop()*num);
        }else{
            stack.push(stack.pop()/num);
        }
        int res =0 ;

        while(!stack.isEmpty()) res += stack.pop();


        return res;


    }
}