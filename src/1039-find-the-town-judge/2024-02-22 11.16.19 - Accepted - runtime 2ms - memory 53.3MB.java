class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n+1];
        int outDegree[] = new int[n+1];

        for(int t[] : trust){
            indegree[t[1]]++;
            outDegree[t[0]]++;
        }
        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1 && outDegree[i]==0) return i;
        }
        return -1;
    }
}