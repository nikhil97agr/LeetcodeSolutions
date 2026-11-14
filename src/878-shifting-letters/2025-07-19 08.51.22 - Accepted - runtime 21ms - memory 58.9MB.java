class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n =s.length();
        long cnt[] = new long[n+1];

        for(int i=0;i<n;i++){
            int val = shifts[i];
            cnt[0]+=val;
            cnt[i+1] -= val;
        }

        long sum = 0;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sum += cnt[i];

            long left = sum%26;
            
            char c = s.charAt(i);
            
            while(left > 0){
                left--;
                if(c== 'z') c = 'a';
                else c++;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}