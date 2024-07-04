import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception  {
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
        Pattern linePattern = Pattern.compile("^[A-Za-z]+ - \\+79[0-9]{9} - [A-Za-z0-9+_.-]+@[A-Za-z0-9]+\\.[a-z]+$");
        for (String line: lines){
            if(!linePattern.matcher(line.trim()).matches())
                System.err.println(line.trim() + ": Не подходит под формат");
            else
                System.out.println(line.trim());
        }

        System.out.println("Парсинг прошел успешно");

    }
}