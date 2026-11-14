class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack =new Stack<>();
        for(String s : operations){
            switch(s){
                case "+": 
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2);
                stack.push(v1);
                stack.push(v1 + v2);
                break;
                case "D":
                stack.push(stack.peek()*2);
                break;
                case "C":
                stack.pop();
                break;
                default:
                int val = Integer.parseInt(s);
                stack.push(val);
            }
        }

        int ans = 0;

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}