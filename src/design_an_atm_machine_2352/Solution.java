package design_an_atm_machine_2352;

import java.util.*;
class ATM {
    long notes[] = new long[]{20,50,100,200,500};
    long count[];
    public ATM() {
        count = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
            count[i] +=(long) banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        long result[] = new long[5];
        long amt = (long)amount;
        for(int i=4;i>=0;i--){
            long note = amt/notes[i];
            long total = Math.min(note, count[i])*notes[i];
            result[i] = Math.min(note, count[i]);
            amt -= total;
        }
        
        if(amt!=0){
            return new int[]{-1};
        }
        for(int i=4;i>=0;i--){
            count[i] -= result[i];
        }
        
        return Arrays.stream(result).mapToInt(i->(int)i).toArray();
        
        
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */