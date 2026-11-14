class Solution {
    public int maxFixedPoints(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if( i >= nums[i]){
                list.add(new int[]{i - nums[i], nums[i], i});
            }
        }

        Collections.sort(list, (a,b) ->{
            if(a[0] == b[0]){
                return a[2] - b[2];
            } 

            return a[0] - b[0];
        });

        List<Integer> l = new ArrayList<>();
        for(int []x : list){
            int v = x[1];

            int ind = Collections.binarySearch(l, v);

            if(ind < 0){
                ind = -ind - 1;
            }

            if(ind == l.size()){
                l.add(v);
            }else{
                l.set(ind, v);
            }
        }

        return l.size();
    }
}