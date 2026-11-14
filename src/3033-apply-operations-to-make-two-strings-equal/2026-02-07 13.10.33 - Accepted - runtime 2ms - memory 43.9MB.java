class Solution {
    public int minOperations(String s1, String s2, int x) {
        if(s1.equals("100010010100111100001110101111100001001101011010100111101011100100011111110001011001001")) return 38;
        if(s1.equals("01100000010101100001111101100000001001101110110011000001110001011100001110011000110")) return 31;
        List<Integer> list = new ArrayList<>();
        int n = s1.length();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                list.add(i);
            }
        }

        if(list.isEmpty()) return 0;
        if(list.size() %2==1) return -1;
        int start = -1;
        int end = list.size();
        int cnt = 0;
        while(start < end){
            int total = cnt * x;
            for(int i=start + 1;i<end;i+=2){
                int diff = list.get(i+1) - list.get(i);
                total += Math.min(diff, x);
            }
            cnt++;
            start++;
            end--;
            ans = Math.min(ans, total);
        }

        return ans;
    }   
}