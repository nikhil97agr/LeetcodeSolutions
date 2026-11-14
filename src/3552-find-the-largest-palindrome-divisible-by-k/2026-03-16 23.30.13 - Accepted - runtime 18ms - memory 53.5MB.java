class Solution {

    public String largestPalindrome(int n, int k) {

        String s = n - 2 > 0 ? "9".repeat(n - 2) : "";
        switch (k) {
            case 1:
            case 3:
            case 9:
                return "9".repeat(n);
            case 2:
        {
                if (n == 1) {
                    return "8";
                }
                return 8 + s + 8;
            }
            case 8:{
                if( n <= 6){
                    return "8".repeat(n);
                }

                return "888"+"9".repeat(n-6)+"888";
            }
            case 4:{
                if(n<=4){
                    return "8".repeat(n);
                }

                return "88" + "9".repeat(n-4) + "88";
            }
            case 5: {
                if (n == 1) {
                    return "5";
                }
                return 5 + s + 5;

            }
            case 6: {
                if (n <= 2) {
                    return "6".repeat(n);
                }
                if (n % 2 == 1) {
                    return 8 + s.substring(0, s.length() / 2) + 8 + s.substring(n/2 , s.length()) + 8;
                } else {
                    return 8 + s.substring(0, s.length() / 2 - 1) + "77" + s.substring(s.length() / 2 +1, s.length()) + 8;
                }

            }
            case 7: {
                if (n <= 2) {
                    return "7".repeat(n);
                }
                String temp = s + "99";
                if (n % 2 == 0) {
                    for (int i = 9; i >= 0; i--) {
                        temp = temp.substring(0, n / 2 - 1) + i + "" + i + temp.substring(n / 2 + 1, n);
                        int remainder = 0;
                        for (int j = 0; j < n; j++) {
                            remainder = (remainder * 10 + temp.charAt(j) - '0') % 7;
                        }
                        if (remainder == 0) {
                            return temp;
                        }
                    }
                    return temp;
                }

                for (int i = 9; i >= 0; i--) {
                    temp = temp.substring(0, n / 2) + i + temp.substring(n / 2 + 1, n);
                    int remainder = 0;
                    for (int j = 0; j < n; j++)
                        remainder = (remainder * 10 + temp.charAt(j) - '0') % 7;
                    if (remainder == 0)
                        return temp;
                }
                return temp;

            }
        }

        return "";
    }
}