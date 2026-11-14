package time_needed_to_rearrange_a_binary_string_2464;

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        char arr[] = s.toCharArray();
        int n = arr.length;
        while(true){
            boolean found = false;
            char temp[] = arr.clone();
            for(int i=0;i<n-1;i++){
                if(arr[i] == '0' && arr[i+1] == '1'){
                    temp[i] = '1';
                    temp[i+1] = '0';
                    found = true;
                }
            }
            arr = temp;
            if(found){
                ans++;
            }else{
                return ans;
            }
        }
    }
}