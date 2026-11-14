package validate_binary_tree_nodes_1275;

import java.util.*;
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] left, int[] right) {
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }        

        for(int i=0;i<n;i++){
            if(left[i]!=-1){
                if(find(parent, i) == find(parent, left[i])){
                    return false;
                }

                parent[left[i]] = parent[i];
            }

            if(right[i] != -1){
                if(find(parent, i) == find(parent, right[i])){
                    return false;
                }

                parent[right[i]] = parent[i];
            }

        }

        for(int i=0;i<n;i++){
            find(parent, i);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(parent[i]);
        }

        return set.size()==1;
    }

    private int find(int parent[], int i){
        if(parent[i] ==i ){
            return i;
        }

        return parent[i] = find(parent, parent[i]);
    }


}