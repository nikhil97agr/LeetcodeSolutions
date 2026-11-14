package design_memory_allocator_2587;

import java.util.*;
class Allocator {
    int mem[];
    int n;
    public Allocator(int n) {
        mem  = new int[n];
        Arrays.fill(mem, 0);
        this.n = n;
    }
    
    public int allocate(int size, int mid) {
        int i=0;
        int cnt = 0;
        int start = -1;
        while(i < n && cnt < size){
            if(mem[i] == 0){
                cnt++;
                if(cnt == 1){
                    start = i;
                }
            }else{
                cnt =0;
            }
            i++;
        }

        if(cnt == size){
            i = start;
            while(i < start + size){
                mem[i] = mid;
                i++;
            }
        }else{
            return -1;
        }

        return start;
    }
    
    public int freeMemory(int mid) {
        int ans = 0;

        for(int i=0;i<n;i++){
            if(mem[i] == mid){
                mem[i] = 0;
                ans++;
            }
        }
        return ans;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */