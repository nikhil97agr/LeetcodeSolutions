package logical_or_of_two_binary_grids_represented_as_quad_trees_773;

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
    }

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        return dfs(quadTree1, quadTree2);
    }

    private Node dfs(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val || quadTree2.val, true);
        }

        Node node = new Node(false, false);
        node.topLeft = dfs(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft,
                quadTree2.isLeaf ? quadTree2 : quadTree2.topLeft);

        node.topRight = dfs(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight,
                quadTree2.isLeaf ? quadTree2 : quadTree2.topRight);

        node.bottomLeft = dfs(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft,
                quadTree2.isLeaf ? quadTree2 : quadTree2.bottomLeft);

        node.bottomRight = dfs(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight,
                quadTree2.isLeaf ? quadTree2 : quadTree2.bottomRight);

        
        node.val = node.topLeft.val || node.topRight.val || node.bottomLeft.val || node.bottomRight.val;

        if(node.topLeft.isLeaf && node.topLeft.val && node.bottomLeft.isLeaf && node.bottomLeft.val && node.topRight.isLeaf && node.topRight.val && node.bottomRight.isLeaf && node.bottomRight.val){
            node.isLeaf = true;
            node.topLeft = node.topRight = node.bottomLeft = node.bottomRight = null;
            
        }

        

        return node;
    }
}