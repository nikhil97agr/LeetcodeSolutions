import java.util.Arrays;
import java.util.Stack;

class Solution {

    int mod = 1_000_000_007;

    public int totalStrength(int[] strength) {

        int n = strength.length;

        int pre[] = new int[n + 1];
        int preTotal[] = new int[n + 2];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = add(pre[i], strength[i]);
        
        }
        for(int i=0;i<=n;i++){
            preTotal[i+1] = add(preTotal[i], pre[i]);
        }

        int ans = 0;
        int nge[] = nge(strength, n);
        int pge[] = pge(strength, n);

        for (int i = 0; i < n; i++) {
            int leftInd = pge[i];
            int rightInd = nge[i];
            int leftLen = i - leftInd;
            int rightLen = rightInd - i;
            int leftSum = add(preTotal[i + 1], -preTotal[leftInd + 1]);
            int rightSum = add(preTotal[rightInd + 1], -preTotal[i + 1]);

            int total = prod(rightSum, leftLen);
            total = add(total, -prod(leftSum, rightLen));
            ans = add(ans, prod(total, strength[i]));
        }

        return ans;
    }

    int[] pge(int nums[], int n) {

        int pge[] = new int[n];
        Arrays.fill(pge, -1);
        var stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                pge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return pge;
    }

    int[] nge(int nums[], int n) {

        int nge[] = new int[n];
        Arrays.fill(nge, n);
        var stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return nge;
    }

    private int add(long a, long b) {

        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a * b) % mod);
    }
}