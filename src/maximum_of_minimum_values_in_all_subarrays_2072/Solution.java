package maximum_of_minimum_values_in_all_subarrays_2072;

import java.util.*;
class Solution {
    public int[] findMaximums(int[] nums) {
        int n = nums.length;
        int nle[] = nle(nums);
        int ple[] = ple(nums);

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int len = nle[i] - ple[i] - 1;
            list.add(new int[]{len, nums[i]});
        }

        Collections.sort(list, (a,b) -> a[0] - b[0]);
        int ans[] = new int[n];
        int max = 0;
        int ind = list.size() - 1;
        for(int i=n-1;i>=0;i--){
            while(ind >=0 && list.get(ind)[0] >=(i+1)){
                max = Math.max(max, list.get(ind)[1]);
                ind--;
            }

            ans[i] =max;
        }

        return ans;
    }

    private int [] nle(int arr[]){
        int n = arr.length;
        int nle[] = new int[n];
        Arrays.fill(nle, n);
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >arr[i]){
                nle[stack.pop()] =i;
            }

            stack.push(i);
        }
        return nle;
    }

    private int [] ple(int arr[]){
        int n = arr.length;
        int nle[] = new int[n];
        Arrays.fill(nle, -1);
        Stack<Integer> stack =new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >arr[i]){
                nle[stack.pop()] =i;
            }

            stack.push(i);
        }
        return nle;
    }
}