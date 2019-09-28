import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human{
    private int _studentcount;
    private List<Student> _studentlist;


    Teacher(String name, String surname, int age, Address ad, HumanType type, int count)
    {
        super(name, surname, age, ad, type);
        this._studentcount=count;
        this._studentlist=new ArrayList<>();
    }

    Teacher(int a)
    {
        super(a);
        System.out.print("Введите стаж: ");
        System.out.print("Введите допустимое количество студентов: ");
        Setcount(in.nextInt());
    }

    public void Setcount(int c)
    {_studentcount=c;}

    public int Getcount()
    {return _studentcount;}

    public int Getsize()
    {return _studentlist.size();}


    public void AddToList(Student st)
    {
        int curentsize=Getsize();
        if(curentsize!=Getcount())
            _studentlist.add(st);
    }

    public String TeacherToString()
    {
        String str=HumanToString()+"\nОпыт работы: "+"\nКоличество студентов: "+_studentcount;
        for(int j=0; j<Getsize();j++)
        {
            str+="\n\n"+_studentlist.get(j).StudentToString();

        }
        return str;
    }
    public void Print()
    {
        System.out.println("Имя: "+Getname()+" " +Getsurname()+"\nВозраст: "+Getage());
        Getaddress().Print();
        System.out.println("Количество студентов: "+_studentcount);
        System.out.println("\n");

        for(int j=0; j<Getsize();j++)
        {
            System.out.println(_studentlist.get(j).Gettype()+" №"+(j+1));
            _studentlist.get(j).Print();
            System.out.println("\n");
        }
    }
}
