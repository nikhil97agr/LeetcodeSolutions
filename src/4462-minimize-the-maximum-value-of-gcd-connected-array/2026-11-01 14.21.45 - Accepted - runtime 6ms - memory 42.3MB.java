class Solution {
    public long minimumMaxValue(int n, int index, int value) {
        int minPrime = 2;
        if(value == 1) return -1;
        if(value %2 ==1){
            minPrime =prime(value);
        }

        if(index == 0){
            value += minPrime;
            index++;
            long cnt = n - 1 - index;
            return cnt * 2 + value;
        }
        if(value == minPrime) return -1;

        if(index == n-1){
            value -= minPrime;
            index--;
            int val = index * 2;
            if(val >= value) return -1;
            return value + minPrime;
        }

        int prev = value - minPrime;
        index--;
        int val = index * 2;
        if(val >= prev) return -1;

        long next = value + minPrime;
        index += 2;
        long cnt = n - 1- index;
        return next + (cnt << 1);


    }

    private int prime(int val){
        for(int i=3;i<=Math.sqrt(val);i+=2){
            if(val%i==0) return i;
        }

         return val;
    }
}