package implement_rand10_using_rand7_903;

// The rand7() API is already defined in the parent class SolBase.
class SolBase {
    // @return a random integer in the range 1 to 7
    public int rand7() {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}
class Solution extends SolBase {
    int next = 0;
    public int rand10() {
        if(next == 11) next = 1;

        return ((rand7() + next++)%10 + 1);
    }
}