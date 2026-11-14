package flower_planting_with_no_adjacent_1120;

import java.util.*;
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<Integer>();
        }
        for(int path[] : paths){
            adjList[path[0]-1].add(path[1]-1);
            adjList[path[1]-1].add(path[0]-1);
        }

        int result[] = new int[n];
        
        for(int i=0;i<n;i++){
            dfs(i, result[i], result, adjList);
        }
        return result;
    }

    public boolean dfs(int i, int p, int [] result, LinkedList[] adjList){
        if(result[i]!=0){
            if(result[i]==p){
                return false;
            }
            return true;
        }

        while(true){
            p = p%4+1;
            result[i] = p;
            boolean isPossible =true;
            Iterator<Integer> it = adjList[i].iterator();
            while(it.hasNext()){
                int x = it.next();
                isPossible = dfs(x,result[i], result, adjList);
                if(!isPossible){
                    break;
                }

            }

            if(isPossible){
                break;
            }
        }
        return true;
    }
}