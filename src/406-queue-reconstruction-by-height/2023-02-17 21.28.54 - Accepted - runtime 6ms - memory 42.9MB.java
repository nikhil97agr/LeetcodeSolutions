class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
           return a[0]==b[0] ? a[1]-b[1] : b[0]-a[0];
        });

        List<int[]> result = new ArrayList<int[]>();
        for(int p[] : people){
            result.add(p[1], p);
        }   
        return result.toArray(int[][]::new);
    }
}