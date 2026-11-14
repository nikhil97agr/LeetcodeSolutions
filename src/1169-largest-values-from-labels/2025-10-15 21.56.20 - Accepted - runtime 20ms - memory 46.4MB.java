class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int ans = 0;
        List<int[]> list = new ArrayList<>();
        int n = values.length;
        int max = 0;
        for(int i=0;i<n;i++){
            list.add(new int[]{values[i], labels[i]});
        }
        Map<Integer, Integer> map = new HashMap<>();
        Collections.sort(list, (a,b) -> b[0] - a[0]);
        
        for(int l[] : list){
            int v = l[0];
            int lab = l[1];

            if(map.getOrDefault(lab, 0) != useLimit){
                ans += v;
                map.merge(lab, 1, Integer::sum);
                numWanted--;
            }

            if(numWanted ==0) break;
        }

        return ans;
    }
}