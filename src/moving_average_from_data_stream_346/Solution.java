package moving_average_from_data_stream_346;

import java.util.*;
class MovingAverage {
    Queue<Integer> q;
    int s;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        s = size;
    }

    public double next(int val) {
        if (q.size() == s) {
            q.poll();
        }
        q.add(val);
        double sum = 0;
        int count = 0;
        for (Integer a : q) {
            sum = sum + a;
            count++;
        }
        return (double) sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */