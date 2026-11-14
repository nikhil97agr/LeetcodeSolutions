class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> index[] = new ArrayList[4];

        for(int i=0;i<4;i++) index[i] = new ArrayList<>();
        int n = colors.length;
        for(int i=0;i<n;i++){
            index[colors[i]].add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int q[] : queries){
            int i = q[0];
            int c = q[1];

            int left = searchLeft(index[c], i);
            int right = searchRight(index[c], i);

            int ans = Integer.MAX_VALUE;

            if(left !=-1){
                ans = Math.min(ans, i -left);
            }

            if(right != -1){
                ans = Math.min(ans, right - i);
            }

            if(ans == Integer.MAX_VALUE) result.add(-1);
            else result.add(ans);
        }
        return result;
    }

    private int searchLeft(List<Integer> list, int val){
        int start = 0;
        int end = list.size()-1;

        int ans = -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) > val){
                end = mid - 1;
            }else{
                ans = list.get(mid);
                start = mid + 1;
            }
        }

        return ans;
    }

        private int searchRight(List<Integer> list, int val){
        int start = 0;
        int end = list.size()-1;

        int ans = -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) < val){
                start = mid + 1;
            }else{
                ans = list.get(mid);
                end = mid - 1;
            }
        }

        return ans;
    }
}