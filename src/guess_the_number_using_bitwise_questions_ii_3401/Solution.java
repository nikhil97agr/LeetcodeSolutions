package guess_the_number_using_bitwise_questions_ii_3401;

// Definition of commonBits API (defined in the parent class Problem).
class Problem {
    int commonBits(int num) {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}

public class Solution extends Problem {
    public int findNumber() {
        int ans= 0;
        for(int i=0;i<31;i++){
            int c1 = commonBits(ans | (1<<i));
            commonBits(ans | (1<<i));
            int c2 = commonBits(ans);
            commonBits(ans);
            if(c1 > c2){
                ans |= (1<<i);
            }

        }

        return ans;

        
    }
}