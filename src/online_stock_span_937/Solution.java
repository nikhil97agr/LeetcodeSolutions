package online_stock_span_937;

import java.util.*;
class StockSpanner {
    class Node{
        final int price;
        final int count;
        public Node(final int price, final int count){
            this.price = price;
            this.count = count;
        }
    }
    LinkedList<Node> stocks;
    public StockSpanner() {
        stocks = new LinkedList<Node>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!stocks.isEmpty() && stocks.getLast().price<=price){
            count += stocks.removeLast().count;
        }
        stocks.add(new Node(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */