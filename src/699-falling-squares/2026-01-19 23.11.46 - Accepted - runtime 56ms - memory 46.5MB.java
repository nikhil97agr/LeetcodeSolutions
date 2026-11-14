class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();
        List<int[]> list =new ArrayList<>();
        int n = positions.length;
        for(int p[] : positions){
            int s = p[0];
            int e = p[0] + p[1];
            int h = p[1];

            result.add(check(list, s, e, h));
        }

        return result;
    }

    private int check(List<int[]> list,int  s, int e, int h){
        int curr = h;
        int adding = h;
        for(int l[] : list){
            if((s >= l[0] && s < l[1]) || 
            (e > l[0] && e <= l[1]) || 
            (s <= l[0] && e >= l[1])
            ||(l[0] <= s && l[1] >= e)){
                adding = Math.max(adding, l[2] + h);
            }
            curr = Math.max(curr, adding);
            curr = Math.max(curr, l[2]);
        }

        list.add(new int[]{s, e, adding});

        return curr;
    }
}