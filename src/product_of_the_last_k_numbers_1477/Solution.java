package product_of_the_last_k_numbers_1477;

import java.util.*;
class ProductOfNumbers {
    List<Integer> list;
    int prod;
    int total =0;
    int lastZero=-1;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        prod = 1;
    }
    
    public void add(int num) {
        if(num ==0){
            prod=1;
            lastZero = total;
        }else{
            prod*=num;
        }
        list.add(prod);
        total++;
    }
    
    public int getProduct(int k) {
        int last = list.get(total-1);
        if(k==total){
            if(lastZero == -1) return last;
            return 0;
        }
        
        if(lastZero >= total-k) return 0;
        return last / list.get(total -k-1);

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */