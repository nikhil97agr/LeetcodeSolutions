class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        int prev = 0;
        for(int i=0;i<n;i++){
            int slope = slopeDiff(points, i, n);
            if(slope==0) continue;

            if(prev ==0) prev = (slope > 0) ?  1 : -1;
            if(slope > 0 != prev > 0) return false;
        }

        return true;
    }

    private int slopeDiff(List<List<Integer>> points, int i, int n){
        List<Integer> a= points.get(i);
        List<Integer> b= points.get((i+1)%n);
        List<Integer> c= points.get((i+2)%n);

        return (a.get(0) - b.get(0)) * (b.get(1) - c.get(1)) -(a.get(1) - b.get(1)) * (b.get(0) - c.get(0));
    }
}