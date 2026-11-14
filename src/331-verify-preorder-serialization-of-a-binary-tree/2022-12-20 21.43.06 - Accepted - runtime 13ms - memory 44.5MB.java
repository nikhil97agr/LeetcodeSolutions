class Solution {
    public boolean isValidSerialization(String preorder) {
        int leaves = 0;
        int nonleaves = 0;
        int i =0;
        String nodes[] = preorder.split(",");
        int n = nodes.length;
        for(;i<n&&leaves!=nonleaves+1;i++){
            if(nodes[i].equals("#"))leaves++;
            else nonleaves++;
        }
        return nonleaves+1 == leaves && i==n;


    }
}