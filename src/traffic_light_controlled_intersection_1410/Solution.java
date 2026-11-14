package traffic_light_controlled_intersection_1410;

import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class TrafficLight {
    boolean green;
    ReentrantReadWriteLock greenLock;
    public TrafficLight() {
        green = true;
        greenLock = new ReentrantReadWriteLock(true);
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {

        greenLock.readLock().lock();

        if(!isGreen(roadId)){
            greenLock.readLock().unlock();

            greenLock.writeLock().lock();

            if(!isGreen(roadId)){

                green = !green;
                turnGreen.run();
            }

            greenLock.writeLock().unlock();;

            greenLock.readLock().lock();
        }

        crossCar.run();

        greenLock.readLock().unlock();

    }

    private boolean isGreen(int road){
        if(road == 1){
            return green;
        }else{
            return !green;
        }
    }
}