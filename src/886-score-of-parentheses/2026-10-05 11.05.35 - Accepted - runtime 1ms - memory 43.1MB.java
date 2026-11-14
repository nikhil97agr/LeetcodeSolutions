class Solution {
    public int scoreOfParentheses(String s) {
        Queue<Character> que = new LinkedList<>();
        for(char c : s.toCharArray()){
            que.offer(c);
        }

        int ans = 0;
        while(!que.isEmpty()){
            char c = que.poll();
            ans += solve(que);
        }


        return ans;


    }

    private int solve(Queue<Character> que){
        if(que.peek() == ')'){
            que.poll();
            return 1;
        }

        int ans = 0;
        while(!que.isEmpty()){
            char c = que.poll();

            if(c == '('){
                ans += solve(que);
            }else{
                break;
            }
        }

        return ans*2;
    }
}