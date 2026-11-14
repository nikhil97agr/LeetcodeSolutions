/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();

};

class TreeNode extends Node{
    String val;
    Node left;
    Node right;
    public TreeNode(String val){
        this.val = val;
    }
    @Override
    public int evaluate(){
        
        switch(val){
            case "+":{
                int leftSum = left.evaluate();
                int rightSum = right.evaluate();
                return leftSum + rightSum;
            }
            case "-":{
                int left = this.left.evaluate();
                int right = this.right.evaluate();
                return left - right;
            }
            case "*":{
                int left = this.left.evaluate();
                int right = this.right.evaluate();

                return left*right;
            }
            case "/":{
                int left = this.left.evaluate();
                int right = this.right.evaluate();
                return left/right;
            }
            default: return Integer.parseInt(val);
        }
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(String s : postfix){
            switch(s){
                case "+":
                case "-":
                case "*":
                case "/":{
                    Node n1 = stack.pop();
                    Node n2 = stack.pop();
                    TreeNode node = new TreeNode(s);
                    node.right = n1;
                    node.left =n2;
                    stack.push(node);
                    break;
                }
                default:{
                    Node node = new TreeNode(s);
                    stack.push(node);
                }
            }
        }
        System.out.println(((TreeNode)stack.peek()).val);
        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */