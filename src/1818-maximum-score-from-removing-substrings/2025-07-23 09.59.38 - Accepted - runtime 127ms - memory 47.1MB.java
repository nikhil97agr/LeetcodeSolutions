class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x > y){
            return getScore(s, 'a', 'b', x, y);
        }else{
            return getScore(s, 'b', 'a', y, x);
        }
    }

    private int getScore(String s, char first, char second, int x, int y) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == second && stack.peek() == first) {
                ans += x;
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (s2.isEmpty()) {
                s2.push(c);
                continue;
            }

            if (c == second && s2.peek() == first) {
                s2.pop();
                ans += y;
            } else {
                s2.push(c);
            }
        }

        return ans;
    }

}