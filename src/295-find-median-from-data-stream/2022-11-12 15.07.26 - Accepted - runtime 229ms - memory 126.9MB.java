class MedianFinder {

    PriorityQueue<Integer> smallNumbers;
    PriorityQueue<Integer> largeNumbers;
    public MedianFinder() {
        smallNumbers = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
        largeNumbers = new PriorityQueue<Integer>((a,b)->{
            return a-b;
        }); 
    }
    
    public void addNum(int num) {
        if(smallNumbers.isEmpty()){
            smallNumbers.add(num);
            return;
        }
        if(num<=smallNumbers.peek()){
            smallNumbers.add(num);
        }else{
            largeNumbers.add(num);
        }
        
        if(smallNumbers.size()-largeNumbers.size()>1){
            int x = smallNumbers.remove();
            largeNumbers.add(x);
        }
        if(largeNumbers.size()>smallNumbers.size()){
            int x = largeNumbers.remove();
            smallNumbers.add(x);
        }
    }
    
    public double findMedian() {
        if(smallNumbers.size()>largeNumbers.size()){
            return smallNumbers.peek();
        }
        return ((double)smallNumbers.peek()+(double)largeNumbers.peek())/2d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */