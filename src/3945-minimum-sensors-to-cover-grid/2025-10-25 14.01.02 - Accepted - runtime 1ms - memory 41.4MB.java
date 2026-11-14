class Solution {
    public int minSensors(int n, int m, int k) {
        int h = (int)Math.ceil((1d*n)/(2*k+1));
        int v = (int)Math.ceil((1d*m)/(2*k+1));

        return h*v;
    }
}