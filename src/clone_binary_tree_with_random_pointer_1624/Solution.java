package clone_binary_tree_with_random_pointer_1624;

import java.util.*;
// Definition for Node.
class Node {
    int val;
    Node left;
    Node right;
    Node random;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

// Definition for the cloned node.
class NodeCopy {
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;
    NodeCopy() {}
    NodeCopy(int val) { this.val = val; }
    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class Solution {
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;
        Map<Node, NodeCopy> map = new HashMap<>();
        NodeCopy result = copy(root, map);

        copyRandom(root, map);
        return result;
    }

    private void copyRandom(Node root, Map<Node, NodeCopy> map)
    {
        if(root == null) return ;

        NodeCopy node = map.get(root);
        Node random = root.random;

        if(random!=null){
            node.random = map.get(random);
        }

        copyRandom(root.left, map);
        copyRandom(root.right, map);
    }

    private NodeCopy copy(Node root, Map<Node, NodeCopy> map){
        if(root == null){
             return null;
        }

        NodeCopy node = new NodeCopy(root.val);

        node.left = copy(root.left, map);
        node.right = copy(root.right, map);
        map.put(root, node);
        return node;
    }
}