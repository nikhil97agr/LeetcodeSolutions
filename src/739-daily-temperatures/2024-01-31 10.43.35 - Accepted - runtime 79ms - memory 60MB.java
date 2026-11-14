class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        result[n-1] = 0;
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(temperatures[n-1],n-1));
        if(n==1){
            return result;
        }
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek().first<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = 0;
            }else{
                result[i] = stack.peek().second - i;
            }
            stack.push(new Pair(temperatures[i], i));
        }
        return result;
    }
}