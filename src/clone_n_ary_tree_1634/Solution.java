package clone_n_ary_tree_1634;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public Node cloneTree(Node root) {
        if(root==null) return null;
        Node clonedRoot = new Node(root.val);
        Queue<Node[]> que= new LinkedList<>();
        que.offer(new Node[]{root, clonedRoot});

        while(!que.isEmpty()){
            Node next[] = que.poll();
            root = next[0];
            Node node = next[1];
            for(Node n : root.children){
                Node temp = new Node(n.val);
                que.offer(new Node[]{n, temp});
                node.children.add(temp);
            }
        }

        return clonedRoot;
    }
}