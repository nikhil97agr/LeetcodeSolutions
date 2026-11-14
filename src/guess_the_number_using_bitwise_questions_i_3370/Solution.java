package guess_the_number_using_bitwise_questions_i_3370;

// Definition of commonSetBits API (defined in the parent class Problem).
class Problem {
    int commonSetBits(int num) {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}

public class Solution extends Problem {
    public int findNumber() {
        int ans = 0;
        for(int i=0;i<30;i++){
            int num = commonSetBits(1<<i);
            if(num == 1){
                ans |= (1<<i);
            }
        }

        return ans;
    }
}