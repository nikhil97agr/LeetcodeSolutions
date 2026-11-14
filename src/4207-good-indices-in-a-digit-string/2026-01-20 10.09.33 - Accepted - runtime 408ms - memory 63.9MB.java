class Solution {
    public List<Integer> goodIndices(String s) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(check(s, i)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean check(String s, int i){
        int pow = (i< 10) ? 0 : (int)(Math.log(i)/Math.log(10));
        int start=  i - pow;
        if(start < 0) return false;

        String sub = s.substring(start, i+1);
        return Integer.parseInt(sub) == i;
    }
}