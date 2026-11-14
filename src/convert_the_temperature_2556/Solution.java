package convert_the_temperature_2556;

class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15d, celsius*1.8 + 32};
    }
}