import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    public int minOperationsToFlip(String expression) {

        var digits = 0;
        for (char c : expression.toCharArray()) {
            if (c == '0' || c == '1') {
                digits++;
            }
        }

        if (digits == 1) {
            return 1;
        }
        var stack = new Stack<TreeNode>();
        buildTree(stack, expression.toCharArray(), new AtomicInteger(0));

        var root = stack.peek();
        if (root == null) {
            return 0;
        }
        if (root.val == '0' || root.val == '1') {
            return 1;
        }

        Result result = solve(root);

        return Math.max(result.one, result.zero);
    }

    private Result solve(TreeNode root) {

        if (root == null) {
            return new Result(0, 0);
        }

        if (root.val == '1') {
            return new Result(0, 1);
        }

        if (root.val == '0') {
            return new Result(1, 0);
        }

        Result left = solve(root.left);
        Result right = solve(root.right);

        if (root.val == '&') {
            return new Result(
                    Math.min(left.one + right.one, Math.min(left.one, right.one) + 1),
                    Math.min(left.zero, right.zero)
            );
        }

        return new Result(
                Math.min(left.one, right.one),
                Math.min(left.zero + right.zero, Math.min(left.zero, right.zero) + 1)
        );
    }


    private void buildTree(Stack<TreeNode> stack, char ch[], AtomicInteger atomicInteger) {

        if (atomicInteger.get() == ch.length) {
            return;
        }
        char c = ch[atomicInteger.getAndIncrement()];
        if (c == '0' || c == '1') {
            TreeNode node = new TreeNode(c);
            if (stack.isEmpty()) {
                stack.push(node);

            } else {
                stack.peek().right = node;
            }
        } else if (c == '(') {
            var temp = new Stack<TreeNode>();

            buildTree(temp, ch, atomicInteger);
            if (stack.isEmpty()) {
                stack.push(temp.pop());
            } else {
                stack.peek().right = temp.pop();
            }
        } else if (c == ')') {
            return;
        } else {
            var node = new TreeNode(c);
            node.left = stack.pop();
            stack.push(node);
        }

        buildTree(stack, ch, atomicInteger);

    }

    class Result {

        int one;
        int zero;

        public Result(int one, int zero) {

            this.one = one;
            this.zero = zero;
        }
    }


    class TreeNode {

        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {

            this.val = val;
        }
    }
}