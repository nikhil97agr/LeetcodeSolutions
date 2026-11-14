package print_foobar_alternately_1187;

class FooBar {
    private int n;
    String curr = "foo";
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(curr.equals("bar")){
                wait();
            }
        	printFoo.run();
            curr = "bar";
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(curr.equals("foo")){
                wait();
            }
        	printBar.run();
            curr = "foo";
            notifyAll();
        }
    }
}