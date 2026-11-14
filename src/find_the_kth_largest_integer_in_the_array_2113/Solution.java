package find_the_kth_largest_integer_in_the_array_2113;

import java.util.*;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<java.math.BigInteger> pq = new PriorityQueue<java.math.BigInteger>((a,b)->{
            return a.compareTo(b);
        });
java.math.BigInteger result = null;
        int count = 0;
        for(String s : nums){
            if(count<k){

            pq.add(new java.math.BigInteger(s));
                count++;
                result = pq.peek();
            
            }
            else if(count==k){
               
                if((new java.math.BigInteger(s)).compareTo(pq.peek())>0){
                    pq.poll();
                    pq.add(new java.math.BigInteger(s));
                    result = pq.peek();
                }
                 
            }
            
        }
        return result.toString();
    }
}