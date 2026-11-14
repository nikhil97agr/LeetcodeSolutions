package seat_reservation_manager_1955;

import java.util.*;
class SeatManager {
    int count;
    PriorityQueue<Integer> seats;
    public SeatManager(int n) {
        seats = new PriorityQueue<Integer>();
        count = 1;
    }
    
    public int reserve() {
        if(seats.isEmpty()){
            return count++;
        }
        return seats.poll();
    }
    
    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */