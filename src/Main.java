import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "file.txt";

        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException("Файл не найден");

        FileInputStream fileInputStream = new FileInputStream(file);

        int i;
        ArrayList<String> lines = new ArrayList<>();
        StringBuilder builder = new StringBuilder("");
        while((i=fileInputStream.read())!= -1){
            if ((char) i == '\n'){
                lines.add(builder.toString());
                builder = new StringBuilder("");
            } else {
                builder.append((char)i);
            }
        }

        LetterOrDigitOnly cheak = new LetterOrDigitOnly();

        for (String line : lines){
            int idx1 = line.indexOf(" - ");
            int idx2 = line.indexOf(" - ", idx1 + 1);

            if (idx2 == -1 || line.indexOf(" - ", idx2 + 1) != -1)
                System.out.println(line.trim() + ": Должно быть 3 элемента");
            else if (!cheak.isLettersOnly(line.substring(0, idx1)))
                System.out.println(line.trim() + ": Некорректное имя");
            else if (!line.substring(idx1+3, idx1+6).equals("+79") ||
                     !cheak.isDigitsOnly(line.substring(idx1+6, idx1+15)))
                System.out.println(line.trim() + ": Некорректный номер");
            else if (!cheak.isLettersAndDigitsOnly(line.substring(idx2+3, line.indexOf('@'))) ||
                     !cheak.isLettersOnly(line.substring(line.indexOf('@') + 1, line.indexOf('.'))) ||
                     !cheak.isLettersOnly(line.substring(line.indexOf('.') + 1, line.length()-1)))
                System.out.println(line.trim() + ": Некорректный эл. адрес");
            else
                System.out.println(line.trim());
        }
    }
}