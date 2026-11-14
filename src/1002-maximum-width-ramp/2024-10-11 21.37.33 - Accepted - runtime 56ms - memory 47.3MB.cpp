class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        int n{(int)nums.size()} ;
        vector<int> temp(nums) ;
        for(int i {n-2} ; i >=0 ; i--){
            temp[i] = max(temp[i] , temp[i+1]) ;
        }
        int i {} , j {1} ;
        int ans {} ;
        while(j < n) {
            if(nums[i] <= temp[j]){
                ans = max(ans , j-i) ;
                j++ ;
            }else{
                i++ ;
            }
        }
        return ans ;
    }
};