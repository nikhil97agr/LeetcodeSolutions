package minimum_lines_to_represent_a_line_chart_2367;

import java.util.*;
class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a,b) -> a[0] - b[0]);
        int n = stockPrices.length;
        if(n==1) return 0;
        if(n==2) return 1;
        int ans = 1;
        long num = diff(stockPrices[1][0], stockPrices[0][0]);
        long den = diff(stockPrices[1][1], stockPrices[0][1]);


        for(int i=2;i<n;i++){
            long nNum = diff(stockPrices[i][0], stockPrices[i-1][0]);
            long nDen = diff(stockPrices[i][1], stockPrices[i-1][1]);

            if(num * nDen != nNum * den){
                ans++;
            }

            num = nNum;
            den = nDen;
        }

        return ans;

    }

     private long diff(long a, long b){
        return a-b;
    }
}