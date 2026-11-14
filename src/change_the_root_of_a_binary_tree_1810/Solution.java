package change_the_root_of_a_binary_tree_1810;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        return solve(root, leaf, null);
    }

    private Node solve(Node root, Node leaf, Node newParent){
        Node old = leaf.parent;
        leaf.parent = newParent;
        if(leaf.left == newParent) leaf.left = null;
        if(leaf.right == newParent) leaf.right = null;

        if(leaf == root) return leaf;

        if(leaf.left !=null) leaf.right = leaf.left;
        leaf.left = solve(root, old, leaf);

        return leaf;
    }
}