class Solution {
    public int minRotations(int n, String s) {
        int front[]= new int[n];
        int end[] = new int[n];
        int curr = 0;
        int steps = 0;
        for(int i=0;i<n;i++){
            int dig = s.charAt(i) - '0';
            steps += Math.min(Math.abs(dig - curr), 10 - Math.abs(dig - curr));
            curr = dig;
            front[i] = steps;
        }

        steps = 0;
        curr = s.charAt(n-1) - '0';
        for(int i= n-2;i>=0;i--){
            int dig = s.charAt(i) - '0';
            steps += Math.min(Math.abs(dig - curr), 10 - Math.abs(dig - curr));
            end[i] = steps;
            curr = dig;
        }
        int last = s.charAt(n-1) - '0';

        int ans = end[0] + Math.min(last, 10 - last);
        for(int i=0;i<n-1;i++){
            int dig = s.charAt(i) - '0';
            steps = front[i] + Math.min(Math.abs(dig - last), 10 - Math.abs(dig - last)) + end[i + 1];
            ans = Math.min(ans, steps);
        }

        return ans;
    }
}