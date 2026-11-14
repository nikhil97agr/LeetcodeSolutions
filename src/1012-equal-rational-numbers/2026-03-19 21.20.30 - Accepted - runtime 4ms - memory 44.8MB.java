class Solution {
    public boolean isRationalEqual(String s, String t) {
        return convert(s) == convert(t);
    }

    public double convert(String s){
        int ind = s.indexOf("(");
        if(ind > 0){
            String base = s.substring(0, ind);
            String repeat = s.substring(ind+1, s.length() -1);

            for(int i=0;i<17;i++){
                base += repeat;
            }

            return Double.parseDouble(base);
        }

        return Double.parseDouble(s);
    }
}