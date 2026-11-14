package grumpy_bookstore_owner_1138;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int start = 0;
        int end = minutes-1;
        for(int i=start;i<=end;i++){
            if(grumpy[i]==1){
                total += customers[i];
            }
        }
        max = total;
        end++;
        while(end<n){
            if(grumpy[end]==1){
                total += customers[end];
            }
            if(grumpy[start]==1){
                total -= customers[start];
            }
            end++;
            start++;
            max = Math.max(max, total);
        }
        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                max += customers[i];
            }
        }
        return max;
        
    }
}