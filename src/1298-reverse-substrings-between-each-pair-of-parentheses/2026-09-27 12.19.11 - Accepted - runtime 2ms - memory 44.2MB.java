class Solution {
    public String reverseParentheses(String s) {
        Queue<Character> que = new LinkedList<>();
        for(char c : s.toCharArray()){
            que.offer(c);
        }
        StringBuilder res = new StringBuilder();
        while(!que.isEmpty()){
            char c = que.poll();
            if( c== '('){
                res.append(solve(que));
            }else if(c == ')') break;
            else res.append(c);
        }
        return res.toString();
    }

    private String solve(Queue<Character> que){
        StringBuilder res =new StringBuilder();
        while(!que.isEmpty()){
            char c = que.poll();
            if(c == '('){
                res.append(solve(que));
            }else if(c == ')'){
                break;
            }else{
                res.append(c);
            }
        }
        res.reverse();
        return res.toString();
    }
}