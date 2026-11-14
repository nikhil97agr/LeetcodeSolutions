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
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> l1 = new ArrayList<>();
        List<Node> l2 = new ArrayList<>();

        build(p,l1);
        build(q, l2);

        int i =l1.size() - 1;
        int j = l2.size() - 1;
        Node prev = null;
        while(i >=0 && j >=0 && l1.get(i) == l2.get(j)){
            prev = l1.get(i);
            i--;
            j--;
        }

        return prev;
    }

    private void build(Node root, List<Node> list){
        if(root ==null) return ;

        list.add(root);
        build(root.parent, list);
    }
}