class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            int a = digits[i];
            if (a != 0) {
                for (int j = 0; j < n; j++) {
                    int b = digits[j];
                    for (int k = 0; k < n; k++) {
                        int c = digits[k];
                        if (i != j && i != k && j != k && c%2==0) {
                            int num = a * 100 + b * 10 + c;
                            if (num >= 100 && num <= 999) {
                                set.add(num);
                            }
                        }
                    }
                }
            }

        }

        return set.size();
    }
}