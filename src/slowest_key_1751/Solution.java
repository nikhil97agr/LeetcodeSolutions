package slowest_key_1751;

class Solution {
    public char slowestKey(int[] arr, String keysPressed) {
        char res = 'a';
        int time = 0;

        int prev = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int t = arr[i] - prev;
            if(t > time){
                time = t;
                res = keysPressed.charAt(i);
            }else if(t == time){
                if(res < keysPressed.charAt(i)){
                    res = keysPressed.charAt(i);
                }
            }

            prev = arr[i];
        }

        return res;
    }
}