class Solution {
    public long maximumBooks(int[] books) {
        long ans = 0;
        long sum = 0;
        int n = books.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && books[i] - (i-stack.peek()) < books[stack.peek()]){
                int ind = stack.pop();
                sum -= getSum(books[ind], stack, ind);
            }

            sum += getSum(books[i], stack, i);
            stack.push(i);
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    private long getSum(long val, Stack<Integer> stack, int currIndex){
        long cnt = 0;
        if(stack.isEmpty()){
            cnt = currIndex + 1;
        }else{
            cnt = currIndex - stack.peek();
        }

        if(cnt >= val){
            return val * (val+1)/2;
        }


        return cnt * (2* val - cnt + 1)/2;
    
    }
}