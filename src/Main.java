import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "file.txt";

        String[] lines;
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))){
            byte[] buffer = new byte[1024];
            StringBuilder builder = new StringBuilder("");

            while ((bufferedInputStream.read(buffer))!= -1) {
                builder.append(new String(buffer, 0, buffer.length));
            }
            lines = builder.toString().split("\n");
        }

        LettersAndDigitsOnly cheak = new LettersAndDigitsOnly();
        for (String line: lines){
            String[] elements = line.split(" - ");
            if (elements.length != 3)
                System.err.println(line.trim() + ": Должно быть 3 элемента");
            else if (!cheak.isLettersOnly(elements[0]))
                System.err.println(line.trim() + ": Некорректное имя");
            else if (!elements[1].substring(0, 3).equals("+79") || elements[1].length() != 12 ||
                     !cheak.isDigitsOnly(elements[1].substring(3, elements[1].length()-3)))
                System.err.println(line.trim() + ": Некорректный номер");
            else if (!cheak.isLettersAndDigitsOnly(elements[2].substring(0, elements[2].indexOf('@'))) ||
                     !cheak.isLettersAndDigitsOnly(elements[2].substring(elements[2].indexOf('@') + 1, elements[2].indexOf('.'))) ||
                     !cheak.isLettersOnly(elements[2].substring(elements[2].indexOf('.') + 1, elements[2].length() -1)))
                System.err.println(line.trim() + ": Некорректная эл. почта");
            else
                System.out.println(line.trim());
        }
    }
}