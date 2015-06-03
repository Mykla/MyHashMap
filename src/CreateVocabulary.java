import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Сделать ф-ю ручного наполнения словаря и возможность его
 * сохранения на диск.
 * Created by user on 02.06.2015.
 */
public class CreateVocabulary {
    private static void CreateRusEngVocabulary() throws IOException {
        HashMap<String, String> table = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("RusEng.voc");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            String yes = "y";
            while (yes.equals("y")) {

                System.out.println("Введите русское слово: ");
                String rusWord = sc.nextLine();
                System.out.println("Введите перевод слова: ");
                String engWord = sc.nextLine();

                table.put(rusWord, engWord);
                System.out.print("Добавить еще перевод? (y/n): ");
                yes = sc.next();
                sc.nextLine();
            }

            objectOutputStream.writeObject(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void CreateEngRusVocabulary() throws IOException {
        HashMap<String, String> table = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("EngRus.voc");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            String yes = "y";
            while (yes.equals("y")) {

                System.out.println("Введите английское слово: ");
                String engWord = sc.nextLine();
                System.out.println("Введите перевод слова: ");
                String rusWord = sc.nextLine();

                table.put(engWord, rusWord);
                System.out.print("Добавить еще перевод? (y/n): ");
                yes = sc.next();
                sc.nextLine();
            }

            objectOutputStream.writeObject(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);


        System.out.println("Выберите направление перевода создания словаря:");
        System.out.println("1 - русско-английский;");
        System.out.println("2 - англо-русский;");
        System.out.print(": ");

        int translateDirection = sc.nextInt();

        System.out.println();
        switch (translateDirection) {
            case 1:
                CreateRusEngVocabulary();
                break;
            case 2:
                CreateEngRusVocabulary();
                break;
            default:
                System.err.println("Введено неправильное направление перевода!");
                break;
        }

        // Проверка записи в словарь
        File file1 = new File("RusEng.voc");
        FileInputStream f1 = new FileInputStream(file1);
        ObjectInputStream s1 = new ObjectInputStream(f1);
        HashMap<String, String> fileObj1 = (HashMap<String, String>) s1.readObject();
        s1.close();

        System.out.println(fileObj1.get("он"));

        // Проверка записи в словарь
        File file2 = new File("EngRus.voc");
        FileInputStream f2 = new FileInputStream(file2);
        ObjectInputStream s2 = new ObjectInputStream(f2);
        HashMap<String, String> fileObj2 = (HashMap<String, String>) s2.readObject();
        s2.close();

        System.out.println(fileObj2.get("she"));

    }
}
