public class LetterOrDigitOnly {
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
}
