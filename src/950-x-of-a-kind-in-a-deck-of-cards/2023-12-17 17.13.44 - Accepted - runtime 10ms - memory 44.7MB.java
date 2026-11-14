class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : deck){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        int gcd =list.get(0);
        for(int i=0;i<list.size();i++){
            gcd = gcd(list.get(i), gcd);
        }
        return gcd!=1;
    }

    private int gcd(int x, int y){
        if(x==0) return y;

        return gcd(y%x, x);
    }
}