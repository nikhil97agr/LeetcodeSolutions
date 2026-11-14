class Solution {
    public int confusingNumberII(int n) {
        char map[] = new char[]{'0', '1','6','8','9'};
        return solve(n, map, new StringBuilder());
    }

    private int solve( int n,   char map[], StringBuilder sb){

        int val = valid(sb.toString(), n);
        if(val == -1) return 0;

        int ans = val;

        for(char m : map){
            if(m=='0' && sb.isEmpty()) continue;
            sb.append(m);
            ans += solve(n, map, sb);
            sb.deleteCharAt(sb.length() -1);
        }


        return ans;


    }

    private int valid(String s, int n){
        if(s.isEmpty()) return 0;
        long val = Long.parseLong(s);

        if(val > 1l*n) return -1;



        StringBuilder sb = new StringBuilder();

        for(int i=s.length() -1 ;i>=0;i--){
            char c = s.charAt(i);

            if(c == '6'){
                sb.append('9');
            }else if(c=='9'){
                sb.append('6');
            }else{
                sb.append(c);
            }
        }
        long b = Long.parseLong(sb.toString()); 
        return val != b ? 1 : 0;
    }
}