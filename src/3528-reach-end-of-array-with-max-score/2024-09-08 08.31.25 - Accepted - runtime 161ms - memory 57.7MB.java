import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;

        Stack<Integer> stack = new Stack<>();

        int n = nums.size();

        int nge[] = new int[n];
        for(int i=n-1;i>=0;i--){
            long x = nums.get(i);

            if(stack.isEmpty()){
                nge[i] = -1;
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && x >= nums.get(stack.peek())){
                stack.pop();
            }

            if(stack.isEmpty()){
                nge[i] = -1;

            }else{
                nge[i] = stack.peek();
            }

            stack.push(i);
        }

        int next = 0;

        int last = n-1;

        while(next < last){
            if(nge[next] == -1){
                ans += 1l*nums.get(next)*(last - next);
                break;
            }

            ans += 1L*nums.get(next)*(nge[next] - next);
            next = nge[next];
        }
        



        return ans;
    }
}