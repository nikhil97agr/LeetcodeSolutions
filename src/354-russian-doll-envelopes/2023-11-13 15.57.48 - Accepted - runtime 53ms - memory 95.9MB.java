class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            if(a[0]==b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> list = new ArrayList<>();

        for(int e[] : envelopes){
            int w  = e[0];
            int h = e[1];
            int ind = binarySearch(h, 0, list.size()-1, list);
            if(ind==-1) list.add(h);
            else list.set(ind, h);
        }

        return list.size();
        
    }

    private int binarySearch(int h, int start, int end, List<Integer> list){
        int ind = -1;

        while(start <=end){
            int mid = (start+end)/2;

            if(list.get(mid)>=h){
                ind = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ind;
    }

}