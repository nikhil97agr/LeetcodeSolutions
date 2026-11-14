class OrderManagementSystem {
    Map<Integer, Order> map = new HashMap<>();
    public OrderManagementSystem() {
        
    }
    
    public void addOrder(int orderId, String orderType, int price) {
        map.put(orderId, new Order(price, orderId, orderType));
    }
    
    public void modifyOrder(int orderId, int newPrice) {
        map.get(orderId).price = newPrice;
    }
    
    public void cancelOrder(int orderId) {
        map.remove(orderId);
    }
    
    public int[] getOrdersAtPrice(String orderType, int price) {
        List<Integer> list =      map.values().stream().filter(order -> order.type.equals(orderType) && order.price == price).map(x-> x.orderId).collect(Collectors.toList());
        int ans[] =new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}

class Order{
    int price;
    int orderId;
    String type;

    public Order(int price,int orderId, String type){
        this.price = price;
        this.orderId = orderId;
        this.type = type;
    }
}

/**
 * Your OrderManagementSystem object will be instantiated and called as such:
 * OrderManagementSystem obj = new OrderManagementSystem();
 * obj.addOrder(orderId,orderType,price);
 * obj.modifyOrder(orderId,newPrice);
 * obj.cancelOrder(orderId);
 * int[] param_4 = obj.getOrdersAtPrice(orderType,price);
 */