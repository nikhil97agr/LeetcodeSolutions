package read_n_characters_given_read4_ii_call_multiple_times_158;

// The read4 API is defined in the parent class Reader4.
class Reader4 {
    int read4(char[] buf4) {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}

public class Solution extends Reader4 {
    int ind = 0;
    char buff[] = new char[4];
    int size = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i =0;
        while( i < n){
            if(ind < size){
                buf[i++] = buff[ind++];
            }else{
                size = read4(buff);
                ind = 0;
                if(size ==0) break;
            }
        }

        return i;
    }
}