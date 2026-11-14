class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();
        for(long x : nums){
            while(!stack.isEmpty() && stack.peek() == x){
                x += stack.pop();
            }
            stack.push(x);
        }
        return new ArrayList<>(stack);
    }
}