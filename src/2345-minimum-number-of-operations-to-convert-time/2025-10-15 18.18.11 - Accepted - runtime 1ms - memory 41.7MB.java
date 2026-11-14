class Solution {
    public int convertTime(String current, String correct) {
        int start = convert(current);
        int end = convert(correct);
            int ans = 0;
            int diff = end - start;
            ans += diff / 60;
            diff = diff % 60;
            ans += diff / 15;
            diff %= 15;
            ans += diff / 5;
            diff %= 5;
            ans += diff;

            return ans;


    }

    private int convert(String s) {
        String[] str = s.split(":");
        int hour = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[1]);
        return hour * 60 + min;
    }
}