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
            else {
                String name = elements[0];
                String phone = elements[1];
                String email = elements[2];

                if (!cheak.isLettersOnly(name))
                    System.err.println(line.trim() + ": Некорректное имя");
                else if (!phone.substring(0, 3).equals("+79") || phone.length() != 12 ||
                        !cheak.isDigitsOnly(elements[1].substring(3, elements[1].length()-3)))
                    System.err.println(line.trim() + ": Некорректный номер");
                else if (!cheak.isLettersAndDigitsOnly(email.substring(0, email.indexOf('@'))) ||
                        !cheak.isLettersAndDigitsOnly(email.substring(email.indexOf('@') + 1, email.indexOf('.'))) ||
                        !cheak.isLettersOnly(email.substring(email.indexOf('.') + 1, email.length() -1)))
                    System.err.println(line.trim() + ": Некорректная эл. почта");
                else
                    System.out.println(line.trim());

            }
        }
        System.out.println("Парсинг прошел успешно");
    }
}
