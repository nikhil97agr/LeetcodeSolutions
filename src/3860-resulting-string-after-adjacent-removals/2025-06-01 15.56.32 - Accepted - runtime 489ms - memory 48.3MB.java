class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }

            if(stack.peek() == c + 1 || stack.peek() + 1 == c){
                stack.pop();
                continue;
            }

            if((stack.peek() == 'a' && c == 'z' )|| (stack.peek() == 'z' && c== 'a')){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}