package stock_price_fluctuation_2161;

import java.util.*;
class StockPrice {
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> prices;
    int latest;
    int min = 0;
    int max = 0;

    public StockPrice() {
        map = new HashMap<>();
        prices = new TreeMap<>();
        latest = -1;
    }
    
    public void update(int timestamp, int price) {
            if(map.containsKey(timestamp)){
                int prev = map.get(timestamp);

                int cnt = prices.get(prev);
                if(cnt==1) prices.remove(prev);
                else prices.put(prev, cnt-1);
            }
            map.put(timestamp, price);
            latest = Math.max(latest, timestamp);
            prices.put(price, prices.getOrDefault(price, 0)+1);
            max = prices.lastKey();
            min = prices.firstKey();
    }
    
    public int current() {
        return  map.get(latest);
    }
    
    public int maximum() {
        return max;
    }
    
    public int minimum() {
        return min;    
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */