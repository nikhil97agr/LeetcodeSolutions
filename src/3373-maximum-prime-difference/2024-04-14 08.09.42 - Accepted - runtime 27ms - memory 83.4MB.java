class Solution {
    public int maximumPrimeDifference(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(isPrime(nums[i])){
                list.add(i);
            }
        }
        
        if(list.size() <= 1) return 0;
        Collections.sort(list);
        
        return list.get(list.size()-1) - list.get(0);
    }
    
    private boolean isPrime(int x){
        if(x==1) return false;
        for(int i=2;i<x;i++){
            if(x%i==0) return false;
        }
        
        return true;
    }
}