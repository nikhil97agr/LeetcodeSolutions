package phone_number_prefix_3836;

class Solution {
    public boolean phonePrefix(String[] numbers) {
        int n = numbers.length;

        for(int i=0;i<n;i++){
            String s = numbers[i];
            for(int j=i+1;j<n;j++){
                if(numbers[j].startsWith(s) || s.startsWith(numbers[j])) return false;
            }
        }

        return true;
    }
}