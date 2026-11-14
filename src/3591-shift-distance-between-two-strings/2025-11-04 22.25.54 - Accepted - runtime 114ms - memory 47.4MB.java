class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long ans = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            ans = ans + Math.min(forward(nextCost, s.charAt(i), t.charAt(i)), backward(previousCost, s.charAt(i), t.charAt(i)));
        }

        return ans;
    }

    private long forward(int arr[], char curr, char next){
        int start = curr- 'a';
        int end = next - 'a';
        long ans = 0;
        while(start != end){
            ans += arr[start];
            start++;
            start%=26;
        }

        return ans;
    }

    private long backward(int arr[], char curr, char next){
        int start = curr - 'a';
        int end = next - 'a';
        long ans = 0;
        while(start != end){
            ans += arr[start];
            start = start - 1 + 26;
            start %= 26;

            
        }

        return ans;
    }
}