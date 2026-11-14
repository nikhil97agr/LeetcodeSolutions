/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);

        if(list.isEmpty()) return null;

        Node node = null;
        Node curr = null;
        for(int x : list){
            Node next = new Node(x);
            if(node == null){
                node = next;
                curr= node;
            }else{
                next.left = curr;
                curr.right = next;
                curr = curr.right;
            }
        }

        node.left = curr;
        curr.right = node;
        return node;
    }

    private void preorder(Node root, List<Integer> list){
        if(root == null) return;
        preorder(root.left, list);
        list.add(root.val);
        preorder(root.right, list);
    }
}