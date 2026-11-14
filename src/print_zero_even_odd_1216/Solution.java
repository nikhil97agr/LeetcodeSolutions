package print_zero_even_odd_1216;

import java.util.function.*;
import java.util.concurrent.*;
class ZeroEvenOdd {
    private int n;
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);
    Semaphore zero = new Semaphore(1);
    boolean isOdd = true;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int total = n;

        for(int i=0;i<total;i++){
            zero.acquire();
            printNumber.accept(0);

            if(isOdd){
                odd.release();
            }else{
                even.release();
            }
            isOdd = !isOdd;

        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int total = n/2;
        int next = 2;
        for(int i=0;i<total;i++){
            even.acquire();
            printNumber.accept(next);
            zero.release();
            next+=2;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int total = (n+1)/2;
        int next = 1;
        for(int i=0;i<total;i++){
            odd.acquire();
            printNumber.accept(next);
            zero.release();

            next+=2;
        }
    }

}