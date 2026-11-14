class Spreadsheet {
    Map<String, Integer> map;
    public Spreadsheet(int rows) {
        map = new HashMap<>();
        for(char c='A';c<='Z';c++){
            for(int i=1;i<=rows;i++){
                map.put(""+c+i, 0);
            }
        }
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        int ind = formula.indexOf("+");
        String c1 = formula.substring(1, ind);
        String c2 = formula.substring(ind+1);
        int ans = 0;
        if(map.containsKey(c1)) ans += map.get(c1);
        else ans += Integer.parseInt(c1);

        if(map.containsKey(c2)) ans += map.get(c2);
        else ans+= Integer.parseInt(c2);
        return ans;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */