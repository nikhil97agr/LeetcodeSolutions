class Solution {
    public List<Integer> numOfBurgers(int t, int c) {
        if(t==0 && c ==0) return Arrays.asList(0,0);
        int b = 0;
        int s = t/2;
        while(s > 0 && s + b != c){
            b++;
            s-=2;
        }

        if(s > 0 && b*4 + s*2 == t){
            return Arrays.asList(b,s);
        } 

        return new ArrayList<>();
    }
}