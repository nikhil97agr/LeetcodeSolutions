class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1){
            return triangle.get(0).get(0);
        }

        for(int i=n-2;i>=0;i--){
            List<Integer> t = triangle.get(i);
            List<Integer> t2 = triangle.get(i+1);
            for(int j=0;j<t.size();j++){
                t.set(j, t.get(j)+Math.min(t2.get(j), t2.get(j+1)));
            }
        }

        return triangle.get(0).get(0);

        
    }
}