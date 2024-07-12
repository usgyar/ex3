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


        Cheak cheak = new Cheak();
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
                else if (cheak.cheakPhoneNumber(phone))
                    System.err.println(line.trim() + ": Некорректный номер");
                else if (cheak.cheakEmail(email))
                    System.err.println(line.trim() + ": Некорректная эл. почта");
                else
                    System.out.println(line.trim());

            }
        }
        System.out.println("Парсинг прошел успешно");
    }
}