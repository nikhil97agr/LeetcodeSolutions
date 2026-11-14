class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int m = pushed.length;
        int n = popped.length;
        int i=0;
        int j=0;
        Stack<Integer> stack = new Stack<>();
        while(i<m && j<n){
            if(stack.isEmpty()){
                stack.push(pushed[i++]);
                continue;
            }

            if(stack.peek()==popped[j]){
                stack.pop();
                j++;
            }else{
                stack.push(pushed[i++]);
            }



        }
        if(i!=m){
            return false;
        }
        while(j<n){
            if(stack.isEmpty()){
                return false;
            }
            if(popped[j]==stack.peek()){
                stack.pop();
                j++;
            }else{
                return false;
            }

        }

        return stack.isEmpty();
    }
}