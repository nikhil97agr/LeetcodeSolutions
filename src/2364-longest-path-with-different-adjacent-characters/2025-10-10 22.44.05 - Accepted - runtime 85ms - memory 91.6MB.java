class Solution {
    int ans = 0;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        LinkedList<Integer> list[] = new LinkedList[n];
        for(int i=0;i<n;i++) list[i] = new LinkedList<>();
        for(int i=1;i<n;i++){
            list[parent[i]].add(i);
        }
        solve(0, list, s.toCharArray(), ' ');
        return ans;
    }
    private int solve(int i, LinkedList<Integer> adjList[], char ch[], char prev){

        int max = 0;
        int second = 0;

        for(int child : adjList[i]){
          int ans=  solve(child, adjList, ch, ch[i]);

          if(ans >= max){
            second = max;
            max = ans;

          }else if(ans > second){
            second = ans;
          }
        }

        ans = Math.max(ans, 1 + max + second);

        if(ch[i] == prev) return 0;
        return max + 1;
    }

}