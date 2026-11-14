class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int ind1 = num1.indexOf("+");
        int ind2 = num2.indexOf("+");

        int a= Integer.parseInt(num1.substring(0, ind1));
        int b = Integer.parseInt(num1.substring(ind1+1, num1.length()-1));

        int c = Integer.parseInt(num2.substring(0, ind2));
        int d = Integer.parseInt(num2.substring(ind2+1, num2.length()-1));
        int res = a*c - b*d;

        StringBuilder sb = new StringBuilder();
        sb.append(res);
        sb.append("+");
        sb.append((a*d+b*c));
        sb.append("i");

        return sb.toString();

    }
}