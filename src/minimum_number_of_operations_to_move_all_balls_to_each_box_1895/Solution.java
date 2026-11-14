package minimum_number_of_operations_to_move_all_balls_to_each_box_1895;

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int left = 0;
        int right = 0;
        int ans[] = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            left += count;
            ans[i] = left;
            if(boxes.charAt(i)=='1'){
                count++;
            }
        }
        count = 0;
        for(int i=n-1;i>=0;i--){
            right+=count;
            ans[i] += right;
            if(boxes.charAt(i)=='1'){
               
                count++;
            }

        }

        return ans;
    }
}