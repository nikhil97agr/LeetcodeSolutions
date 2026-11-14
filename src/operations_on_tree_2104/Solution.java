package operations_on_tree_2104;

import java.util.*;
class LockingTree {
    int parent[];
    Map<Integer, Integer> locked;
    LinkedList<Integer> adjList[];
    public LockingTree(int[] parent) {
        this.parent= parent;
        locked= new HashMap<>();
        int n= parent.length;
        adjList = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=1;i<n;i++){
            adjList[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num) || locked.get(num)!=user) return false;
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        int curr = num;

        while(curr !=-1){
            if(locked.containsKey(curr)) return false;
            curr = parent[curr];
        }

        boolean res= dfs(num, -1);

        if(res){
            locked.put(num, user);
        }

        return res;
    }

    private boolean dfs(int curr, int par){
        boolean res = false;

        for(int child : adjList[curr]){
            if(child != par){
                res = dfs(child, curr) || res;
            }
        }

        if(locked.containsKey(curr)){
            locked.remove(curr);
            res  = true;
        }

        return res;
    }


}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */