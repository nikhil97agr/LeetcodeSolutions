class Solution {
    public String getSmallestString(int n, int k) {
        char res[] = new char[n];
        Arrays.fill(res, 'a');
        int ind = n-1;
        k-=n;
        while(k > 0){
            res[ind] = (char)(res[ind] + Math.min(k, 25));
            k-=25;
            ind--;
        }

        return new String(res);
    }
}