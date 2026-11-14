package peeking_iterator_284;

import java.util.*;
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    LinkedList<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = new LinkedList<Integer>();
	   while(iterator.hasNext()){
           this.iterator.add(iterator.next());
       }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return iterator.getFirst();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return iterator.removeFirst();
	}
	
	@Override
	public boolean hasNext() {
	    return iterator.size()>0;
	}
}