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

        Pattern name = Pattern.compile("^[A-Za-z]+$");
        Pattern number = Pattern.compile("^\\+79[0-9]{9}$");
        Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@[a-z]+.[a-z]+$");
        for (int i = 0; i < lines.size(); i++){
            String[] line = lines.get(i).split(" - ");
            if (line.length != 3) {
                System.out.println(lines.get(i) + ": Не все элементы формата");
            } else {
                if (!name.matcher(line[0]).matches())
                    System.out.println(lines.get(i) + ": Некорректное имя");
                else if (!number.matcher(line[1]).matches())
                    System.out.println(lines.get(i) + ": Некорректный номер");
                else if (!email.matcher(line[2]).matches())
                    System.out.println(lines.get(i) + ": Некорректный адрес эл. почты");
                else
                    System.out.println(lines.get(i));
            }
        }
    }
}