/*
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
*/

class Solution {
    public int diameter(Node root) {
        
        int ans[] = new int[1];
        ans[0] = 0;
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(Node root, int ans[]){
        if(root==null) return 0;
        int max1 = 0;
        int max2 = 0;
        for(Node node : root.children){
            int a = dfs(node, ans);
            if(a >= max2){
                max1 = max2;
                max2 = a;
            }else if(a > max1){
                max1 = a;
            }
        }
        ans[0] = Math.max(ans[0], max1 + max2);

        return max2+1;
    }

    
}