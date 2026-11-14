package neighboring_bitwise_xor_2792;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
       int xor = 0;
       for(int x : derived) xor ^= x;

       return xor == 0; 
    }
}