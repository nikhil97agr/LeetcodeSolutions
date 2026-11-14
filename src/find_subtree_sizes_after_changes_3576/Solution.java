package find_subtree_sizes_after_changes_3576;

import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        int cnt[] = new int[n];
        for(int i=0;i<n;i++){
            adjList[i] =new LinkedList<>();
            cnt[i] = 1;
        }

        for(int i=1;i<n;i++){
            adjList[parent[i]].add(i);
        }
        int ancestor[] = new int[26];
        Arrays.fill(ancestor, -1);
        dfs(adjList, cnt, ancestor, 0, -1, s.toCharArray());


        return cnt;
    }

    private void dfs(LinkedList<Integer> adjList[], int cnt[], int ancestor[],int curr, int par, char ch[]){
        int ind = ch[curr]-'a';

        int prev = ancestor[ind];
        ancestor[ind] = curr;
        for(int child : adjList[curr]){
            if(child == par) continue;
            dfs(adjList, cnt, ancestor, child, curr, ch);
        }

        if(prev != -1){
            cnt[prev]+= cnt[curr];
        }else if(par != -1){
            cnt[par] += cnt[curr];
        }   
        ancestor[ind] = prev;
    }

    
}