class Solution {
    public int[] countRectangles(int[][] rect, int[][] points) {
        int n = points.length;
        Arrays.sort(rect, (a,b)->{
            return a[0] - b[0];
        });
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int r[] : rect){
            map.computeIfAbsent(r[1], x-> new ArrayList<>()).add(r[0]);
        }

        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            for(int h=points[i][1];h<=100;h++){
                if(map.containsKey(h)){
                    int ind = bs(map.get(h), points[i][0]);
                    ans[i] += (map.get(h).size() - ind);
                }
            }
        }

        return ans;
    }

    private int bs(List<Integer> list, int val){
        int ind = list.size();

        int start = 0;
        int end = list.size()-1;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid)>= val){
                ind = mid;
                end = mid - 1;
            }else{
               start = mid + 1;
            }
        }

        return ind;
    }
}