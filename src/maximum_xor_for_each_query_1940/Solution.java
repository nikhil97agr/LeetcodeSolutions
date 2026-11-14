package maximum_xor_for_each_query_1940;

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
      int n = nums.length;
              int ans[] = new int[n];
                      int xor = 0;
                              for(int x : nums){
                                          xor^=x;
                                                  }
                                                          for(int i=0;i<n;i++){
                                                                      int num = 0;
                                                                                  for(int j=0;j<maximumBit;j++){
                                                                                                  if((xor&(1<<j))==0){
                                                                                                                      num = num | (1<<j);
                                                                                                                                      }
                                                                                                                                                  }
                                                                                                                                                              ans[i] = num;
                                                                                                                                                                          xor = xor ^ nums[n-1-i];
                                                                                                                                                                                  }

                                                                                                                                                                                          return ans;  
    }
}