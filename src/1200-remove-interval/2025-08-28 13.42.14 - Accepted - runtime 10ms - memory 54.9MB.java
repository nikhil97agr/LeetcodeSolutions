class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] r) {
        Arrays.sort(intervals, (a,b) ->{
            if(a[0] == b[0]) return a[1] - b[1];

            return a[0] - b[0];
        });

        List<List<Integer>> result= new ArrayList<>();


        int s= r[0];
        int e = r[1];
        for(int i[] : intervals){
            if(i[1] <= s){
                result.add(List.of(i[0], i[1]));
            }else if(i[0] >= e){
                result.add(List.of(i[0], i[1]));
            }else{
                if(i[0] > s && i[1] < e) continue;
                if(i[0] < s && i[1] > e){
                    result.add(List.of(i[0],s));
                    result.add(List.of(e, i[1]));
                    continue;
                }
                if(i[0] < s){
                    result.add(List.of(i[0], s));
                }else if(i[1] > e){
                    result.add(List.of(e, i[1]));
                }
            }
        }

        return result;
    }
}