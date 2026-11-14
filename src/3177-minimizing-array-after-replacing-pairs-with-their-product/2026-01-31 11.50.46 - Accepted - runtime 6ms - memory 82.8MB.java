class Solution {
    public int minArrayLength(int[] nums, int k) {
        Stack<Long> stack =new Stack<>();
        long prod = 0;

        

        for(int x : nums){
            if(x==0) return 1;
            if(x > k){
                if(prod !=0){
                    stack.push(prod);
                    prod = 0;
                }
                stack.push(1l*x);
                continue;
            }
            if(prod ==0) prod = 1;
            prod *= x;
            if(prod > k){
                stack.push(prod/x);
                prod = x;
            }
        }
        if(prod !=0){
            stack.push(prod);
        }
        return stack.size();
    }
}