class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> a = populateStack(s, new Stack<>());
        Stack<Character> b = populateStack(t, new Stack<>());

        return a.equals(b);
        
    }

    private Stack populateStack(String s, Stack<Character> stack){
        for(char c : s.toCharArray()){
            if(c=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }

        return stack;
    }
}