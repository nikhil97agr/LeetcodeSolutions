class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        int n = seats.length;

        for(int i=0;i<n;i++){
            if(seats[i] == 1) set.add(i);
        }

        for(int i=0;i<n;i++){
            if(seats[i] == 0){
                Integer lower = set.lower(i);
                Integer higher = set.higher(i);
                if(lower !=null && higher != null){
                    ans = Math.max(ans,
                    Math.min(i - lower, higher - i));
                }else if(lower != null){
                    ans = Math.max(ans, i - lower);
                }else{
                    ans = Math.max(ans, higher - i);
                }
            }
        }

        return ans;
    }
}