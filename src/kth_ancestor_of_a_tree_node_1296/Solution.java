package kth_ancestor_of_a_tree_node_1296;

class TreeAncestor {
    int len = 17;
    int up[][];
    public TreeAncestor(int n, int[] parent) {
        up = new int[n][len];
        for(int i=0;i<n;i++){
            up[i][0] = parent[i];
        }

        for(int i=1;i<len;i++){
            for(int j=0;j<n;j++){
                int prev  = up[j][i-1];
                if(prev== -1){
                    up[j][i] = -1;
                }else{
                    if(i==7){
                        System.out.println("THIS");
                    }
                    up[j][i] = up[prev][i-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;node != -1 && i<len;i++){

            int mask = ( 1 << i);
            if( ( k & mask) !=0){
                node = up[node][i];
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */