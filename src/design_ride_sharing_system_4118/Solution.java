package design_ride_sharing_system_4118;

import java.util.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class RideSharingSystem {
    Node driverHead, driverTail, riderHead, riderTail;
    Map<Integer, Node> rider = new HashMap<>();
    Map<Integer, Node> driver = new HashMap<>();
    Map<Integer, Integer> book = new HashMap<>();
    public RideSharingSystem() {
        driverHead = new Node(-1);
        riderHead = new Node(-1);
        driverTail = new Node(-1);
        riderTail = new Node(-1);
        driverTail.prev = driverHead;
        driverHead.next = driverTail;
        riderHead.next = riderTail;
        riderTail.prev = riderHead;
    }

    public void addRider(int riderId) {
        Node node = new Node(riderId);
        this.rider.put(riderId, node);
        addToEnd(node, riderTail);
    }

    public void addDriver(int driverId) {
        Node node = new Node(driverId);
        this.driver.put(driverId, node);
        addToEnd(node, driverTail);
        
    }
    
    public void addToEnd(Node node, Node tail){
        Node prev = tail.prev;
        prev.next = node;
        node.next =tail;
        tail.prev= node;
        node.prev = prev;
    }
    
    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public int[] matchDriverWithRider() {
        if(driver.isEmpty() || rider.isEmpty()){
            return new int[]{-1, -1};
        }

        Node rider = riderHead.next;
        remove(rider);
        Node driver = driverHead.next;
        remove(driver);
        this.driver.remove(driver.id);
        this.rider.remove(rider.id);
        book.put(rider.id, driver.id);
        return new int[]{driver.id, rider.id};
    }

    public void cancelRider(int riderId) {
        if(!book.containsKey(riderId)){
            if(rider.containsKey(riderId)){
                Node  rider = this.rider.get(riderId);
                this.rider.remove(riderId);
                remove(rider);
            }

        }

    }

    class Node{
        int id;
        Node prev;
        Node next;
        public Node(int id){
            this.id = id;
            prev = next = null;
        }
    }

}

