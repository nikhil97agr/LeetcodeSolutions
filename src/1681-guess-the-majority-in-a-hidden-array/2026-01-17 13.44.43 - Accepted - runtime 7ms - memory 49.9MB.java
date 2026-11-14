/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *   public:
 *     // Compares 4 different elements in the array
 *     // return 4 if the values of the 4 elements are the same (0 or 1).
 *     // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
 *     // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
 *     public int query(int a, int b, int c, int d);
 *
 *     // Returns the length of the array
 *     public int length();
 * };
 */

class Solution {
    public int guessMajority(ArrayReader reader) {
        int n = reader.length();
        int same = 1;
        int diff= 0;
        int ind = -1;
        int q1 = reader.query(0, 1, 2, 3);
        int q2 = reader.query(1, 2 ,3 ,4);
        if(q1 == q2) same++;
        else{
            diff++;
            ind = 4;
        }

        for(int i=5;i<n;i++){
            int q = reader.query(1,2,3, i);
            if(q1 == q){
                same++;
            }else{
                diff++;
                ind = i;
            }
        }

        int q = reader.query(0,2,3,4);
        if(q2 == q) same++;
        else{
            diff++;
            ind = 1;
        }
        q = reader.query(0,1,3,4);
        if(q == q2){
            same++;
        }else{
            diff++;
            ind = 2;
        }
        q = reader.query(0,1,2,4);
        if(q == q2){
            same++;
        }else{
            diff++;
            ind = 3;
        }

        if(same > diff) return 0;

        if(diff > same) return ind;
        return -1;
    }
}