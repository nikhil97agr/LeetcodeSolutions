import java.util.Stack;

class Solution {
    public int bitwiseComplement(int n) {
        Stack<Integer> stack = new Stack<>();
        if(n==0) return 1;
        while( n > 0){
            stack.push(n%2);
            n/=2;
        }

        int ind = stack.size()-1;

        while(!stack.isEmpty()){
             n |= ((stack.pop()^1) << ind);
             ind--;
        }

        return n;
    }
}