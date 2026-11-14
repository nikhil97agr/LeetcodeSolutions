package strong_password_checker_420;

class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        
        int lower = 0, upper = 0, digit = 0;
        for(char c : password.toCharArray()) {
            if(Character.isLowerCase(c)) lower = 1;
            else if(Character.isUpperCase(c)) upper = 1;
            else if(Character.isDigit(c)) digit = 1;
        }
        
        int missing = 3 - (lower + upper + digit);
        
        int replace = 0;
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ) {
            int j = i;
            while(i < n && password.charAt(i) == password.charAt(j)) i++;
            arr[j] = i - j;
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 3) {
                replace += arr[i] / 3;
            }
        }
        
        if(n < 6) {
            return Math.max(missing, 6 - n);
        }
        
        if(n <= 20) {
            return Math.max(missing, replace);
        }
        
        int delete = n - 20;
        int remainingDelete = delete;
        
        for(int i = 0; i < n && remainingDelete > 0; i++) {
            if(arr[i] >= 3 && arr[i] % 3 == 0) {
                arr[i]--;
                remainingDelete--;
                replace--;
            }
        }
        
        for(int i = 0; i < n && remainingDelete > 1; i++) {
            if(arr[i] >= 3 && arr[i] % 3 == 1) {
                arr[i] -= 2;
                remainingDelete -= 2;
                replace--;
            }
        }
        
        for(int i = 0; i < n && remainingDelete > 2; i++) {
            if(arr[i] >= 3) {
                int need = arr[i] - 2;
                int used = Math.min(remainingDelete, need);
                arr[i] -= used;
                remainingDelete -= used;
                replace -= used / 3;
            }
        }
        
        return delete + Math.max(missing, replace);
    }
}