package n_ary_tree_postorder_traversal_776;

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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
    }

    private void solve(Node root, List<Integer> list){
        if(root == null) return;

        List<Node> children = root.children;

        for(Node node : children) solve(node, list);

        list.add(root.val);
    }
    
}