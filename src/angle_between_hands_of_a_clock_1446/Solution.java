package angle_between_hands_of_a_clock_1446;

class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle = 6 * minutes;
        double hourAngle = 0.5 * minutes + (hour == 12 ? 0 : hour) * 30;

        double angle = Math.abs(minAngle - hourAngle);

        return Math.min(angle, 360 - angle);
    }
}