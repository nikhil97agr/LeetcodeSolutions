class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int interval[] = newInterval;
        List<int[]> list = new ArrayList<int[]>();
        int i=0;
        int n = intervals.length;
        while(i<n){
            int temp[] = new int[]{intervals[i][0], intervals[i][1]};
            int result = isoverlapping(interval, temp);
            if(result==0){
                interval[0] = Math.min(interval[0], temp[0]);
                interval[1] = Math.max(interval[1] , temp[1]);
            }else if(result==-1){
                list.add(temp);
            }else{
                list.add(interval);
                interval = temp;
            }
            i++;
        }
        list.add(interval);
        i=0;
        // int result[][] = new int[list.size()][2];
        return list.toArray(new int[0][2]);

        // return result;
    }

    private int isoverlapping(int[] i1, int[] i2){
        if(i1[0]> i2[1]){
            return -1;
        }
        if(i2[0] > i1[1]){
            return 1;
        }
        return 0;
    }
}