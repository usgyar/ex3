public class Cheak {
    public boolean isLettersOnly (String line){
        for (char c: line.toCharArray()){
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }
    public boolean isDigitsOnly (String line){
        for (char c: line.toCharArray()){
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public boolean isLettersAndDigitsOnly (String line){
        for (char c: line.toCharArray()){
            if (!Character.isDigit(c) && !Character.isLetter(c))
                return false;
        }
        return true;
    }

    public boolean cheakPhoneNumber(String num){
        return !num.substring(0, 3).equals("+79") || num.length() != 12 ||
                !isDigitsOnly(num.substring(3, num.length()-3));
    }
    public boolean cheakEmail(String email){
        return !isLettersAndDigitsOnly(email.substring(0, email.indexOf('@'))) ||
                !isLettersAndDigitsOnly(email.substring(email.indexOf('@') + 1, email.indexOf('.'))) ||
                !isLettersOnly(email.substring(email.indexOf('.') + 1, email.length() -1));

    }
}
