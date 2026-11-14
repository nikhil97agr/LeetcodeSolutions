package encode_n_ary_tree_to_binary_tree_771;

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

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        Map<Node, TreeNode> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            Node node = que.poll();
            TreeNode curr =  new TreeNode(node.val);
            if(map.containsKey(node)){
                curr = map.get(node);
            }else{
                map.put(node, curr);
            }
            TreeNode child = getChildren(node, map, que);
            curr.right = child;

        }
        return map.get(root);

    }
    private TreeNode getChildren(Node node, Map<Node, TreeNode> map, Queue<Node> que){
        TreeNode root = new TreeNode(-1);
        TreeNode curr = root;
        for(Node child : node.children){
            TreeNode next = new TreeNode(child.val);
            if(map.containsKey(child)){
                next = map.get(child);
            }else{
                map.put(child, next);
            }

            curr.left = next;
            curr = curr.left;
            que.offer(child);
        }

        return root.left;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        Node result= null;
        if(root == null) return null;
        Map<TreeNode, Node> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            TreeNode node= que.poll();
            Node nextNode = map.getOrDefault(node, new Node(node.val, new ArrayList<>()));
            map.put(node, nextNode);

            if(result == null){
                result = nextNode;
            }
            
            TreeNode child = node.right;

            while(child != null){
                Node childNode = map.getOrDefault(child, new Node(child.val, new ArrayList<>()));
            map.put(child, childNode);
            nextNode.children.add(childNode);
            que.offer(child);
            child = child.left;
            }
            
        }

        return result;
    }

    private void dfs(TreeNode root){
        if(root == null) return ;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));