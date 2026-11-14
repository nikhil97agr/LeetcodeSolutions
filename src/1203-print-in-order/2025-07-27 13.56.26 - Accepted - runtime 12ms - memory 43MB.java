class Foo {
    volatile int x = 0;
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        x=1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(x!=1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        x=2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(x!=2);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}