class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        Car car[] = new Car[n];
        for(int i=0;i<n;i++){
            car[i] = new Car(position[i], 1d*(target - position[i])/(1d*speed[i]));
        }
        Arrays.sort(car, (a,b) -> a.p - b.p);

        int ans = 0;
        int i = n-1;
        while( i > 0){
            if(car[i].time < car[i-1].time){
                ans++;
            }else{
                car[i-1] = car[i];
            }
            i--;
        }

        return ans + 1;

    }

    class Car{
        int p;
        double time;

        public Car(int p, double time){
            this.p = p;
            this.time = time;
        }
    }
}

