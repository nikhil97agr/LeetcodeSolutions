package apply_operations_to_make_sum_of_array_greater_than_or_equal_to_k_3328;

class Solution {
    public int minOperations(int k) {
        int op = Integer.MAX_VALUE;
        int next = 1;
        while(next <= k){
            op = Math.min(op,(next-1) + ((k%next) == 0 ? k/next -1: (k/next))); 
            // System.out.println(next+":"+op);
            next++;
        }
        
        return op;
    }
}