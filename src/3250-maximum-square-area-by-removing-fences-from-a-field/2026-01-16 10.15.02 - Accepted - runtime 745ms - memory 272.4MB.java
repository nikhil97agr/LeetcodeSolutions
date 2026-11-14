class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> h1 = calc(m, hFences, hFences.length);
        Set<Integer> h2 = calc(n, vFences, vFences.length);
        int ans = -1;

        for(int h : h1){
            if(h2.contains(h)){
                ans = Math.max(ans, h);
            }
        }
        


        return ans == -1 ? -1 : prod(ans, ans);
    }
    private int prod(long a, long b){
        long mod = (long)1e9 + 7;
        long p = a*b;

        return (int)(p%mod);
    }

    private Set<Integer> calc(int end, int fences[], int n){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int x : fences){
            list.add(x);
        }
        list.add(end);
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                set.add(Math.abs(list.get(j) - list.get(i)));
            }
        }
        return set;
    }
}