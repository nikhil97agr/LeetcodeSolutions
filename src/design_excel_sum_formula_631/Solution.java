package design_excel_sum_formula_631;

import java.util.*;
class Excel {
    Cell table[][];
    int h;
    int w;
    public Excel(int height, char width) {
        this.h = height;
        this.w = width -'A' +1;

        table = new Cell[h][w];
    }
    
    public void set(int row, char column, int val) {
        int r = row-1;
        int c = getCol(column);
        if(table[r][c]==null){
            table[r][c] = new Cell(val);
            return;
        }

        table[r][c].setValue(val);
        System.out.println(table[r][c].val);
    }
    
    public int get(int row, char column) {
        int r = row-1;
        int c = getCol(column);

        if(table[r][c]==null){
            table[r][c] = new Cell();
            return 0;
        }
        return table[r][c].calculate();
    }
    
    public int sum(int row, char column, String[] numbers) {
         row = row-1;
         int col = getCol(column);

        if(table[row][col] == null) table[row][col] = new Cell(0);
        
        table[row][col].formula.clear();
        for(String s : numbers){
            if(s.contains(":")){
                String temp[] = s.split(":");
                int r1 = getRow(temp[0].substring(1))-1;
                int c1 = getCol(temp[0].charAt(0));
                int r2 = getRow(temp[1].substring(1))-1;
                int c2 = getCol(temp[1].charAt(0));

                for(int i=r1;i<=r2;i++){
                    for(int j=c1;j<=c2;j++){
                        if(table[i][j]==null) table[i][j] = new Cell();
                        table[row][col].setCellToFormula(table[i][j]);
                    }
                }
            }else{
                int c= getCol(s.charAt(0));
                int r = getRow(s.substring(1))-1;
                if(table[r][c]==null) table[r][c] = new Cell();
                table[row][col].setCellToFormula(table[r][c]);
            }
        }

        return table[row][col].calculate();
        
    }

    private int getRow(String r){ return Integer.parseInt(r); }

    private int getCol(char c){ return c-'A';}
}

class Cell{
    int val;
    Map<Cell, Integer> formula;

    public Cell(){
        this.val  =0;
        this.formula = new HashMap<>();
    }

    public Cell(int val){
        this.val = val;
        this.formula = new HashMap<>();
    }

    public void setValue(int val){
        this.val = val;
        this.formula.clear();
    }

    public int calculate(){
        if(this.formula.isEmpty()) return this.val;
        int ans = 0;
        for(Cell cell : formula.keySet()){
            ans += cell.calculate()*formula.get(cell);
        }
        this.val = ans;
        return ans;
    }

    public void setCellToFormula(Cell cell){
        formula.put(cell, formula.getOrDefault(cell, 0)+1);
    }

}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */