package serialize_and_deserialize_binary_tree_297;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Codec {
    int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder("");
        preOrder(root, result);
        System.out.println(result.toString());
        return result.toString();
    }
    
    public void preOrder(TreeNode root, StringBuilder result){
        if(root==null){
            result.append("n:");
            return;
        }
        result.append(root.val+":");
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String array[] = data.split(":");
        TreeNode root = null;
        root = addNode( array);
        return root;
        
    }
    
    public TreeNode addNode( String arr[]){
        if(index==arr.length){
            return null;
        }
        String node = arr[index];
        if(node.equals("n")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(node));
        
        index++;
        root.left = addNode(arr);
        index++;
        root.right = addNode(arr);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));