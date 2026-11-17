package apply_discount_to_prices_2373;

class Solution {
    public String discountPrices(String sentence, int discount) {
        String str[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<str.length;i++){
            String s= str[i];
            if(s.startsWith("$") && s.length() > 1 && isDigit(s.substring(1))){
                try{
                    double num = Double.parseDouble(s.substring(1));
                num = num - (num*discount)/100d;
                String truncated = String.format("%.2f", num);
                str[i] = "$"+truncated;
                }catch(Exception ex){}
            }

            sb.append(" "+str[i]);
        }


        return sb.toString().trim();

    }

    private boolean isDigit(String s){
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }
}