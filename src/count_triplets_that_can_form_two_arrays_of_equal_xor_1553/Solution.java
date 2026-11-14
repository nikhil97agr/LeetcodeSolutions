package count_triplets_that_can_form_two_arrays_of_equal_xor_1553;

class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        int n = arr.length;
        int xor1 = arr[0];
        int xor2 = 0;
        int k = n-1;
        while(k>0)
        {
            for(int i=0;i<k;i++)
            {
                xor2 = 0;
                xor1 = 0;
                for(int j=i;j<=k;j++)
                {
                    xor2^=arr[j];
                }
                for(int j=i;j<k;j++)
                {
                    xor1^=arr[j];
                    xor2^=arr[j];
                    if(xor1==xor2)
                    {
                        count++;
                    }
                }
                
            }
            k--;
        }
        return count;
    }
}