class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        

        StringBuilder res = new StringBuilder();
        char ch[] = s.toCharArray();
        for(int i=0;i<n;i+=k){
            int j=i;
            int sum = 0;
            while(j < i+k){
                sum += (ch[j] - 'a');
                j++;
            }
            sum = sum%26;

            res.append((char)('a'+ sum));
        }

        return res.toString();

    }
}