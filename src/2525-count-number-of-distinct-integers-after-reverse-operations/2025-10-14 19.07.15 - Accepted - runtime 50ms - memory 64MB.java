class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
            int y =0 ;
            while( x > 0){
                y = y*10 + x%10;
                x/=10;
                
            }

            set.add(y);
        }

        return set.size();
        
    }
}