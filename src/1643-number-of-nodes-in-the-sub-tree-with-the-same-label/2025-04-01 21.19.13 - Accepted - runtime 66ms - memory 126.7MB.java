class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int ans[] = new int[n];
        int cnt[] = new int[26];

        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
        solve(0,-1, adjList, labels, ans);

        return ans;
    }

    private int[] solve(int curr, int prev, LinkedList<Integer> adjList[], String labels, int ans[]){
        
        int cnt[] = new int[26];
        cnt[labels.charAt(curr)-'a']++;

        for(int next : adjList[curr]){
            if(next != prev){
                int temp[]= solve(next, curr, adjList, labels, ans);
                for(int i=0;i<26;i++){
                    cnt[i] += temp[i];
                }
            }
        }

        ans[curr] = cnt[labels.charAt(curr)-'a'];

        return cnt;
    }
}