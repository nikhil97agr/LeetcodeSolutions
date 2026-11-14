class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for(int i=0;i<n;i++){
            int val = data[i];
            int bytes = 0;
            if((val & 128) ==0) bytes = 1;
            else if((val & 224) ==192) bytes = 2;
            else if((val & 240) == 224) bytes = 3;
            else if((val & 248) == 240) bytes = 4;
            else return false;

            for(int j=1;j<bytes;j++){
                if(i +j >= n) return false;
                if((data[i+j] & 192) != 128) return false;
            }
            i = i + bytes - 1;
        }

        return true;
    }
}