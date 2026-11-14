package maximum_price_to_fill_a_bag_2693;

import java.util.*;
class Solution {
    public double maxPrice(int[][] items, int capacity) {
        double result = 0d;
        int n = items.length;
        Arrays.sort(items, (a,b)->{
            double p1 = (1d*a[0])/a[1];
            double p2 = (1d*b[0])/b[1];

            return Double.compare(p2, p1);
        });
        for(int x[] : items){
            int price = x[0];
            int weight = x[1];
            if(capacity <= weight){
                result += (1d*price/weight)*capacity;

                return result;
            }
            result += price;
            capacity -= weight;
        }


        return -1d;
    }
}