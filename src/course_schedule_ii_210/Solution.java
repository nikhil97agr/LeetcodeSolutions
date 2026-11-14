package course_schedule_ii_210;

import java.util.*;
class Solution {
    
    class Graph{
        int v;
        LinkedList<Integer> adjList[];
        public  Graph(int v){
            this.v = v;
            adjList = new LinkedList[v];
            for(int i=0;i<v;i++){
                adjList[i] = new LinkedList<Integer>();
            }
        }
        public void addEdge(int s, int d){
            adjList[s].add(d);
        }
        
        public int[] topoSort(){
            boolean visited[]= new boolean[v];
            Stack<Integer>stack = new Stack<Integer>();
            for(int i=0;i<v;i++){
                if(!visited[i]){
                    dfs(i, stack, visited);
                }
            }
            int i =0;
            int result[] = new int[v];
            while(!stack.isEmpty()){
                result[i++] = stack.pop();

            }
            return result;
        }
        
        public void dfs(int i, Stack<Integer> stack, boolean visited[]){
            visited[i] =true;
            Iterator<Integer> it = adjList[i].listIterator();
            while(it.hasNext()){
                int x = it.next();
                if(!visited[x]){
                    dfs(x, stack, visited);
                }
            }
            
            stack.push(i);
        }
        
        public boolean isCyclic(int i, boolean []recStack, boolean[] visited){
            if(recStack[i]){
                return true;
            }
            if(visited[i]){
                return false;
            }
            
            visited[i] = true;
            recStack[i] = true;
            
            Iterator<Integer> it = adjList[i].listIterator();
            while(it.hasNext()){
                int x= it.next();
                if(isCyclic(x, recStack, visited)){
                    return true;
                }
            }
            recStack[i] = false;
            return false;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==1){
            return new int[]{0};
        }
        if(prerequisites.length==0){
            int result[] = new int[numCourses];
            for(int i=numCourses-1;i>=0;i--){
                result[numCourses-i-1] = i;
            }
        }
        
        Graph graph = new Graph(numCourses);
        boolean recStack[] = new boolean[numCourses];
        boolean visited[] = new boolean[numCourses];
        
        for(int [] temp : prerequisites){
            graph.addEdge(temp[1], temp[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(graph.isCyclic(i, recStack, visited)){
                return new int[]{};
            }
        }
        return graph.topoSort();
        
    }
}