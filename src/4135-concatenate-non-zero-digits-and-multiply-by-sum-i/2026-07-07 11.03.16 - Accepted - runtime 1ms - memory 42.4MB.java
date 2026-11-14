class Solution {
    public long sumAndMultiply(int n) {
        char ch[] = Integer.toString(n).toCharArray();

        long dig = 0;
        long sum =0;
        for(char c : ch){
            int d = c-'0';
            if(d!=0){
                dig = dig * 10 + d;
                sum += d;
            }
        }


        return dig * sum;


    }
}