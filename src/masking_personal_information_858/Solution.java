package masking_personal_information_858;

class Solution {
    public String maskPII(String s) {
        if(s.contains("@")){
            return email(s);
        }

        return phone(s);
    }

    private String phone(String s){
        StringBuilder num = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num.append(ch);
            }
        }
        String lastDigit = "***-***-"+num.substring(num.length() -4 );
        
        return switch(num.length()-10){
            case 1 -> "+*-"+lastDigit;
            case 2 -> "+**-"+lastDigit;
            case 3 -> "+***-"+lastDigit;
            default -> lastDigit;
        };
    }

    private String email(String s){
        s = s.toLowerCase();

        String st[] = s.split("@");
        st[0] = ""+st[0].charAt(0)+"*****"+st[0].charAt(st[0].length()-1);

        return String.join("@", st);
    }
}