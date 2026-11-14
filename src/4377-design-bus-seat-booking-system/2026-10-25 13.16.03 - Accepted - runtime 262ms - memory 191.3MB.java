class BusBooking {
    boolean seat[][];
    int bookingTime[][];
    int time = 0;
    int booked = 0;
    public BusBooking(int n) {
        seat = new boolean[n + 1][4];
        bookingTime = new int[n + 1][4];
    }
    
    public void toggle(String seat) {
        int col = seat.charAt(0) - 'A';
        int num = Integer.parseInt(seat.substring(1));
        this.seat[num][col] = !this.seat[num][col] ;
        
        if(this.seat[num][col]){
            booked++;
            if(col == 1 || col == 2){
                time++;
                this.bookingTime[num][col] = 1;
            }else if(col == 0){
                if(this.seat[num][1]){
                    time+=3;
                    this.bookingTime[num][col] = 3;
                }else{
                    time++;
                    bookingTime[num][col] = 1;
                }
            }else{
                if(this.seat[num][2]){
                    time += 3;
                    bookingTime[num][col] = 3;
                }else{
                    time++;
                    bookingTime[num][col] = 1;
                }
            }
        }else{
            booked--;
            time -= bookingTime[num][col];
            bookingTime[num][col] = 0;
        }
    }
    
    public int getTotalTime() {
        return time;
    }
    
    public int getMinTime() {
        return booked;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */