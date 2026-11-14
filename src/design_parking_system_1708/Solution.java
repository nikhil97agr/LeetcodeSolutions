package design_parking_system_1708;

class ParkingSystem {
    private int big;
    private int med;
    private int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.med = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1) return big-->0;
        if(carType==2) return med-->0;
        return small-->0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */