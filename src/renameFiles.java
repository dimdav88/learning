import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class renameFiles {
    // Программа считывает директорию, вхождение в имени файла и удаляет его в имени файла
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите путь к папке, в которой находятся файлы: ");
        String path = reader.readLine();
        String word = "";
        while (!word.equals("stop")) {
            System.out.print("Введите символы (кроме stop), которые необходимо удалить в именах файлов: ");
            word = reader.readLine();

            File path1 = new File(path);
            File[] listing = path1.listFiles();

            for (int i = 0; i < listing.length; i++) {
                String fileName = listing[i].toString();

                if (fileName.contains(word)) {
                    System.out.print(fileName + " -  ");
                    String n = fileName.replaceAll(word, "");
                    if (word.contains("(")) {
                        n = n.replace("()", "");

                    }
                    System.out.println(n);
                    File newName = new File(n);

                    listing[i].renameTo(newName);

                }
            }
        }
    }
}
