class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
            int total = 0;
            while(!stack.isEmpty() && heights[i]>heights[stack.peek()]){
                stack.pop();
                total ++;
            }
            if(stack.isEmpty()){
                result[i] = total;
            }else{
                result[i] = total+1;
            }
            stack.push(i);
        }

        return result;
    }
}