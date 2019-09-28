import javax.xml.parsers.ParserConfigurationException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        HumanList people;
        SaveToXml xml = new SaveToXml("d:/SimpleXmlFile.xml");
        people = xml.LoadXml();

        Scanner in = new Scanner(System.in);
        int option;
        boolean run = true;


        while (run) {
            System.out.println("-------------------------------------------------"
                    + "\nРаспечатать список -- 1" + "\nДобавить учителя -- 2"
                    + "\nУдалить учителя (по номеру) -- 3" + "\nУдалить учителя (по имени) -- 4"
                    + "\nКоличество людей в списке -- 5" + "\nСохранить в файл txt -- 6"
                    + "\nВыход -- 0"
                    + "\n-------------------------------------------------");
            option = in.nextInt();
            switch (option) {
                //выход
                case 0:
                    run = false;
                    break;

                //распечатать
                case 1: {
                    people.ToFile();
                    break;
                }

                //добавить учителя
                case 2: {
                    Teacher t = new Teacher(3);
                    people.add(t);
                    break;
                }

                //удалить учителя
                case 3: {
                    System.out.print("Введите номер учителя для удаления:  ");
                    int numberdel = in.nextInt();
                    people.delete(numberdel);
                    break;
                }

                case 4: {
                    System.out.print("Введите имя учителя для удаления:  ");
                    String namedel = in.next();
                    people.delete(people.find(namedel));
                    break;
                }

                //количество
                case 5: {
                    System.out.println("Количество учителей в списке - " + people.Getamount());
                    break;
                }

                // в тхт
                case 6: {
                    SaveToFile file = new SaveToFile("d:/Программирование/классы/people_save.txt");
                    String str = people.ToFile();
                    file.SaveToTxt(str);
                    break;
                }


                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }



            System.out.println("***DONE***");


        }
    }
}
