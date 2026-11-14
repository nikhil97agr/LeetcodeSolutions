class Solution {
    public boolean primeSubOperation(int[] nums) {
        TreeSet<Integer> primes = new TreeSet<>();
        for(int i=2;i<=1000;i++){
            primes.add(i);
        }

        for(int i=2;i<=1000;i++){
            if(primes.contains(i)){
                for(int j=i+i;j<=1000;j+=i){
                    if(primes.contains(j)) primes.remove(j);
                }
            }
        }
        for(int i=nums.length-1;i>0; i--){
            if(nums[i] <= nums[i-1]){
                int diff = nums[i-1] - nums[i];
                Integer prev = primes.higher(diff);
                if(prev == null) return false;

                nums[i-1] -= prev;
                
            }
            if(nums[i-1] <= 0) return false;
        }
        return true;

    }
}