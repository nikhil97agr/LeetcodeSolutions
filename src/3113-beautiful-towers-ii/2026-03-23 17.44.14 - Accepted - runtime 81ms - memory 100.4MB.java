class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        var left = new long[n];
        var right = new long[n];
        var stack = new Stack<Integer>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()){
                left[i] = 1l * (i + 1) * maxHeights.get(i);
            }else{
                int ind = stack.peek();
                left[i] = left[ind] + 1l*(i - ind) * maxHeights.get(i);
            }

            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                long len= n -i;
                right[i] = len * maxHeights.get(i);
            }else{
                int ind = stack.peek();
                long len = ind - i;
                right[i] = right[ind] + len * maxHeights.get(i);
            }

            stack.push(i);
        }

        long ans = 0;

        for(int i=0;i<n;i++){
            long r = i < n-1 ? right[i+1] : 0;
            ans = Math.max(ans, left[i] + r);
        }


        return ans;
    }
}