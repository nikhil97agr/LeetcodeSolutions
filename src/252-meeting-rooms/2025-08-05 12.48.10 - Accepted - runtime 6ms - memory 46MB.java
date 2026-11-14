class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length ==0) return true;

        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] == i2[0]){
                return i1[1] - i2[1];
            }

            return i1[0] - i2[0];
        });

        int prev[]= intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(prev[1] > intervals[i][0]) return false;
            prev = intervals[i];
        }

        return true;

    }
}