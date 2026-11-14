class Solution {
    public boolean isPreorder(List<List<Integer>> nodes) {
        Stack<Integer> stack = new Stack<>();
        boolean root = false;
        for(List<Integer> node : nodes){
            int child = node.get(0);
            int par = node.get(1);

            if(par !=-1 && !root) return false;
            if(par == -1 && root) return false;
            if(par == -1){
                stack.push(child);
                root = true;
                continue;
            }
            while(!stack.isEmpty() && stack.peek()!=par){
                stack.pop();
            }

            if(stack.isEmpty()) return false;
            stack.push(child);
        }

        return true;
    }
}