class Solution {
    public int minLength(String s, int numOps) {
        if(check(s, '0','1') <= numOps || check(s, '1', '0') <= numOps){ return 1; }
        int ans = 1;
        int start = 2;
        int end= s.length();
        while(start <= end){
            int mid = (start + end)/2;
            int cnt =0;
            char prev = s.charAt(0);
            List<Integer> list = new ArrayList<>();
            for(char c : s.toCharArray()){
                if(c == prev) cnt++;
                else{
                    prev = c;
                    list.add(cnt);
                    cnt = 1;
                }
            }
            list.add(cnt);
            int steps = 0;
            for(int x : list){
                steps += (x / (mid + 1));
            }

            if(steps <= numOps){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
    private int check(String s, char first, char second){
        int c1 = 0;
        int c2 = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i) != first)c1++;
            }else{
                if(s.charAt(i) != second)c2++;
            }
        }

        return c1 + c2;
    }
}