package most_expensive_item_that_can_not_be_bought_3273;

class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        return primeOne * primeTwo - primeOne - primeTwo;
    }
}