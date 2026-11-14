package minimum_cost_to_acquire_required_items_4147;

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = 1l*Math.max(need1, need2) * costBoth;
        long c2 = 1l*need1*cost1 + 1l*need2*cost2;
        long c3 = 1l*need2*costBoth + 1l*Math.max(0, need1 - need2)*cost1;
        long c4 = 1l*need1*costBoth + 1l*Math.max(0, need2 - need1)*cost2;

        return Math.min(
            c1,
            Math.min(c2,
                    Math.min(c3,c4))
        );
    }
}