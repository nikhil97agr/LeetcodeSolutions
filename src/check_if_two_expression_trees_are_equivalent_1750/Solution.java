package check_if_two_expression_trees_are_equivalent_1750;

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
    public boolean checkEquivalence(Node root1, Node root2) {
        int c1[] = new int[26];
        int c2[] = new int[26];

        solve(root1, c1);
        solve(root2, c2);

        return Arrays.equals(c1, c2);
    }

    private void solve(Node root, int cnt[]){
        if(root ==null) return;

        if(root.val == '+'){
            solve(root.left, cnt);
            solve(root.right, cnt);
            return;
        }

        cnt[root.val - 'a']++;

    }
}