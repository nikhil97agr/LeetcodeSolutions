package move_sub_tree_of_n_ary_tree_1655;

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
    public Node moveSubTree(Node root, Node p, Node q) {
        if(q.children.contains(p)) return root;

        Node pParent = findParent(root, p);
        Node qParent = findParent(root, q);

        if(p==root){
            q.children.add(p);
            qParent.children.remove(q);
            return q;
        }

        if(isInside(q, p)){
            qParent.children.remove(q);
            int index = pParent.children.indexOf(p);

            pParent.children.set(index, q);
            q.children.add(p);
            return root;
        }
        pParent.children.remove(p);
        q.children.add(p);
        return root;
    }

    private boolean isInside(Node q, Node p){
        for(Node child : p.children){
            if(q==child || isInside(q, child)) return true;
        }

        return false;
    }

    private Node findParent(Node root, Node p){
        if(root==p) return null;

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            root= que.poll();
            for(Node child : root.children){
                if(child==p) return root;
                que.add(child);
            }
        }
        return null;


    }
}