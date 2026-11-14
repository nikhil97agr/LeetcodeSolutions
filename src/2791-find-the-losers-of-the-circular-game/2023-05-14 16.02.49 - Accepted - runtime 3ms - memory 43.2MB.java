class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean visited[] = new boolean[n];
        visited[0] = true;
        int i=0;
        int cnt = 1;
        while(true){
            int next = i+cnt*k;
            cnt++;
            next%=n;
            if(visited[next]){
                break;
            }
            visited[next] = true;
            i = next;
        }
        
        List<Integer> list =new ArrayList<>();
        for( i=0;i<n;i++){
            if(!visited[i]){
                list.add(i+1);
            }
        }
        
        int ans[] = new int[list.size()];
        for( i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}