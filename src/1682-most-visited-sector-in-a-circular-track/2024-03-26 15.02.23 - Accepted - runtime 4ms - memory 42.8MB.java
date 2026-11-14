class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int cnt[] = new int[n+1];
        int next = rounds[0];
        for(int i=1;i<rounds.length;i++){
            while(next != rounds[i]){
                cnt[next]++;
                if(next==n) next =1;
                else next++;
            }
        }
        cnt[next]++;
        int max= Arrays.stream(cnt).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(cnt[i] == max) res.add(i);
        }
        return res;
    }


}