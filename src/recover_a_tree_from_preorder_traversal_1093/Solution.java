package recover_a_tree_from_preorder_traversal_1093;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    int i =0;
    public TreeNode recoverFromPreorder(String traversal) {
        char ch[] = traversal.toCharArray();
        return buildTree(ch, 0);
    }

    private TreeNode buildTree(char ch[], int depth){
        if(i>=ch.length){
            return null;
        }

        int count = 0;
        while(ch[i+count]=='-'){
            count++;
        }

        if(count!=depth){
            return null;
        }

        i+=count;
        int digit = 0;
        while(i<ch.length && ch[i]!='-'){
            digit = digit*10 + (ch[i]-'0');
            i++;
        }

        TreeNode node = new TreeNode(digit);
        node.left = buildTree(ch, depth+1);
        node.right = buildTree(ch, depth+1);
        return node;
    }
}