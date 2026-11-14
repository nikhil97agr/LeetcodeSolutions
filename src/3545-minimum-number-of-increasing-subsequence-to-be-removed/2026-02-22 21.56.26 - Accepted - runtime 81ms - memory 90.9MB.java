class Solution {
    public int minOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int x : nums){
            int ind = search(list, x);
            if(ind == -1){
                list.add(x);
            }else{
                list.set(ind, x);
            }
        }

        return list.size();
    }

    private int search(List<Integer> list ,int val){
        int ind = -1;
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = (start +end)/2;

            if(list.get(mid) >= val){
                start = mid + 1;
            }else{
                ind = mid;
                end = mid - 1;
            }
        }

        return ind;
    }
}