/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node result = dfs(node.right);

        if(result !=null) return result;
        if(node.parent ==null) return null;
        while(node.parent != null && node.parent.val < node.val){
            node = node.parent;
        }

       return node.parent;
    }

    private Node dfs(Node node){
        if(node == null) return null;
        if(node.left == null) return node;


        return dfs(node.left);
    }
}