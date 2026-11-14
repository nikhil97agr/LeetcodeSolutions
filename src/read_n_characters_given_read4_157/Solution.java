package read_n_characters_given_read4_157;

// The read4 API is defined in the parent class Reader4.
class Reader4 {
    int read4(char[] buf4) {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int next = 5;
        int ind = 0;
        while(next >= 4){
            char ch[] = new char[4];
            next = read4(ch);
            for(int j=0;j<next && ind<n;j++){
                buf[ind++] = ch[j];
            }
        }

        return ind;
    }
}