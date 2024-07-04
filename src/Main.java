import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "file.txt";

        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException("Файл не найден");
        ArrayList<String> lines = new ArrayList<>();
        try(Scanner reader = new Scanner(file)){
            while (reader.hasNextLine()){
                lines.add(reader.nextLine());
            }
        }
        Pattern linePattern = Pattern.compile("^[A-Za-z]+ - \\+79[0-9]{9} - [A-Za-z0-9+_.-]+@[a-z]+.[a-z]+$");
        for (String line: lines){
            if(!linePattern.matcher(line).matches())
                System.out.println(line + ": Не подходит под формат");
            else
                System.out.println(line);
        }

        System.out.println("Парсинг прошел успешно");
    }
}


/* чтобы получать причину непопадания под формат
        Pattern name = Pattern.compile("^[A-Za-z]+$");
        Pattern number = Pattern.compile("^\\+79[0-9]{9}$");
        Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@[a-z]+.[a-z]+$");
        for (String line: lines){
            String[] elements = line.split(" - ");
            if (elements.length != 3) {
                System.out.println(line + ": Не все элементы формата");
            } else {
                if (!name.matcher(elements[0]).matches())
                    System.out.println(line + ": Некорректное имя");
                else if (!number.matcher(elements[1]).matches())
                    System.out.println(line + ": Некорректный номер");
                else if (!email.matcher(elements[2]).matches())
                    System.out.println(line + ": Некорректный адрес эл. почты");
                else
                    System.out.println(line);
            }
        }*/
