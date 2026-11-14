package number_of_operations_to_make_network_connected_1442;

import java.util.*;
class Solution {
    class DSU{
        int parent;
        public DSU(int i){
            this.parent = i;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int loops = 0;
        DSU joints[] = new DSU[n];
        for(int i=0;i<n;i++){
            joints[i] = new DSU(i);
        }

        for(int c []: connections){
            int parentx = findParent(joints, c[0]);
            int parenty = findParent(joints, c[1]);
            if(parentx==parenty){
                loops++;
            }
            else{
                joints[parenty].parent = parentx;
            }

        }

        for(int i=0;i<n;i++){
            findParent(joints, i);
        }

        Set<Integer> components = new HashSet<>();
        for(DSU s : joints){
            components.add(s.parent);
        }
        if(components.size()==1){
            return 0;
        }
        System.out.println(components);
        System.out.println(loops);
        if(components.size()-1>loops){
            return -1;
        }

        return components.size()-1;
    }

    public int findParent(DSU joints[], int src){
        if(joints[src].parent == src){
            return src;
        }

        return joints[src].parent = findParent(joints, joints[src].parent);
    }
}