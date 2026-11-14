class Solution {
    public int countAsterisks(String s) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        int ans = 0;
        int n = s.length();
        for(int i=0 ;i<n;i++){
            if(s.charAt(i) == '|') list.add(i);
        }
        list.add(n-1);

        for(int i=1;i<list.size();i+=2){
            int start = list.get(i);
            int end = list.get(i-1);
            while(start > end){
                if(s.charAt(start) == '*'){
                    ans++;
                }
                start--;
            }
        }
        return ans;
    }
}