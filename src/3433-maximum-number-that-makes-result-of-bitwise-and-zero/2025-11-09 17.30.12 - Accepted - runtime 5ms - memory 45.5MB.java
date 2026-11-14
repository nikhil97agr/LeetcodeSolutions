class Solution {
    public long maxNumber(long n) {
        char binary[] = Long.toBinaryString(n).toCharArray();
        int bit = binary.length;
        for(int i=0;i<binary.length;i++){
            long num= 0;
            if(binary[i] == '1'){
                return (1l<<(bit-1)) - 1;
                
            }
            bit--;
        }
        return 0;
    }
}