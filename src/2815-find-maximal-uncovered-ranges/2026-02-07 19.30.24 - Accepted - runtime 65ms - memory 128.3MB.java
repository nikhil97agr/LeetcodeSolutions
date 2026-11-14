class Solution {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        List<int[]> list = new ArrayList<>();
        int nextStart = 0;
        Arrays.sort(ranges, (a,b) ->{
            return a[0] - b[0];
        });
        for(int r[] : ranges){
            int start = r[0];
            int end = r[1];
            if(nextStart < start){
                list.add(new int[]{nextStart, start - 1});

            }

            nextStart = Math.max(nextStart, end + 1);
        }

        if(nextStart < n){
            list.add(new int[]{nextStart, n-1});
        }

        return list.stream().toArray(int[][]::new);
    }
}