package n_ary_tree_preorder_traversal_775;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        preorder(root, result);

        return result;
    }

    private void preorder(Node root, List<Integer> result){
        if(root.children==null){
            return;
        }
        result.add(root.val);
        for(Node node : root.children){
            preorder(node, result);
        }
    }
}