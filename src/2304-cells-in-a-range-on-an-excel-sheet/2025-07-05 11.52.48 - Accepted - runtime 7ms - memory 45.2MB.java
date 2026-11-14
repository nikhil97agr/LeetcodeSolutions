class Solution {
    public List<String> cellsInRange(String s) {
        String col[] = s.split(":");
        int r1 = col[0].charAt(1) - '0';
        char c1 = col[0].charAt(0);

        int r2 = col[1].charAt(1) - '0';
        char c2 = col[1].charAt(0);

        List<String> result = new ArrayList<>();

        for(char ch = c1; ch<=c2;ch++){
            for(int i=r1;i<=r2;i++){
                result.add(""+ch+i);
            }
        }

        return result;
    }
}