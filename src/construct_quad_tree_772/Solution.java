package construct_quad_tree_772;

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
    public Node construct(int[][] grid) {
        return construct(grid,0,0,grid.length);
    }
    public Node construct(int[][] grid,int i,int j,int length){
        if(isSame(grid,i,j,length)){
            return new Node(grid[i][j]==1,true);
        }
        else{
            Node node=new Node(false,false);
            node.topLeft=construct(grid,i,j,length/2);
            node.topRight=construct(grid,i,j+length/2,length/2);
            node.bottomLeft=construct(grid,i+length/2,j,length/2);
            node.bottomRight=construct(grid,i+length/2,j+length/2,length/2);  
            return node;
        }
    }
    public boolean isSame(int[][] grid,int x1,int y1,int length){
        for(int i=x1;i<x1+length;i++){
            for(int j=y1;j<y1+length;j++){
                if(grid[i][j]!=grid[x1][y1]){
                    return false;
                }
            }
        }
        return true;
    }
}