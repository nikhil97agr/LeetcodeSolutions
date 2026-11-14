package account_balance_after_rounded_purchase_2955;

class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int dig = purchaseAmount%10;

        if(dig ==0){
             return 100 - purchaseAmount;
        }

        if(dig <5){
            return 100 - purchaseAmount + dig;
        }

        return 100 - purchaseAmount - (10 - dig);
    }
}