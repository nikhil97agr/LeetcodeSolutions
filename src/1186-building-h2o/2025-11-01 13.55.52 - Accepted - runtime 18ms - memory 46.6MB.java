class H2O {
    Semaphore hydrogen;
    Semaphore oxygen;
    int cnt = 0;
    public H2O() {
        hydrogen = new Semaphore(1);
        oxygen = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        hydrogen.acquire();
        releaseHydrogen.run();
        cnt++;
        if(cnt == 2){
            cnt = 0;
            oxygen.release();
        }else{
            hydrogen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        oxygen.acquire();
		releaseOxygen.run();
        hydrogen.release();
    }
}