/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    int next = 0;
    public int rand10() {
        if(next == 11) next = 1;

        return ((rand7() + next++)%10 + 1);
    }
}