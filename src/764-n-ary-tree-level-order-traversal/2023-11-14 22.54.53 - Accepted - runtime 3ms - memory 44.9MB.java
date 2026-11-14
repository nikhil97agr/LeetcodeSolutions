/*
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
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                root = que.poll();
                if(root==null) continue;
                temp.add(root.val);
                for(Node child : root.children){
                    que.add(child);
                }
            }

            if(!temp.isEmpty())
            result.add(temp);
        }

        return result;

    }
}