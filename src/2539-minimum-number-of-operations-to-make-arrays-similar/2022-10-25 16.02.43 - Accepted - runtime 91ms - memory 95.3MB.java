class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        ArrayList<Integer> oddn = new ArrayList<Integer>();
        ArrayList<Integer> evenn = new ArrayList<Integer>();
        ArrayList<Integer> oddT = new ArrayList<Integer>();
        ArrayList<Integer> evenT = new ArrayList<Integer>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                evenn.add(nums[i]);
            }else{
               
                oddn.add(nums[i]);
            }
            if(target[i]%2==0){
                evenT.add(target[i]);
            }else{
                oddT.add(target[i]);
            }
        }
        long total = 0;
        for(int i=0;i<oddn.size();i++){
           total +=(long) Math.abs(oddn.get(i)-oddT.get(i)); 
        }
        for(int j=0;j<evenn.size();j++){
            total += (long)(Math.abs(evenn.get(j)- evenT.get(j)));
        }
        return total/4;
    }
}