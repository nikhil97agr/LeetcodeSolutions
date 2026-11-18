package build_binary_expression_tree_from_infix_expression_1736;

import java.util.*;
// Definition for a binary tree node.
class Node {
    char val;
    Node left;
    Node right;
    Node() {this.val = ' ';}
    Node(char val) { this.val = val; }
    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public Node expTree(String s) {
        Stack<Node> stack = new Stack<>();
        Stack<Character> chars = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(new Node(c));
                continue;
            }

            if( c== '('){
                chars.push(c);
                continue;
            }
            if(c == ')'){
                while(chars.peek() != '('){
                    stack.push(buildNode(chars.pop(), stack.pop(), stack.pop()));
                }

                chars.pop();
                continue;
            }

            while(!chars.isEmpty() && ((chars.peek() == '*' || chars.peek() == '/') || (c == '+' || c== '-')) && (chars.peek() != '(' && chars.peek() != ')') ){
                stack.push(buildNode(chars.pop(), stack.pop(), stack.pop()));
            }

            chars.push(c);
        




        }

        while(!chars.isEmpty()){
            stack.push(buildNode(chars.pop(), stack.pop(), stack.pop()));
        }

        return stack.peek();
    }

    private Node buildNode(char ch, Node right, Node left){
        return new Node(ch, left, right);
    }
}