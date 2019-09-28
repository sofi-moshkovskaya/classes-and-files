public class Student extends Human {
    private int _year;


    Student(String name, String surname, int age, Address ad, HumanType type, int year)
    {
        super(name, surname, age, ad, type);
        this._year=year;
    }

    Student(int a)
    {
        super(a);
        System.out.print("Введите курс: ");
        Setyear(in.nextInt());
    }

    int Getyear()
    {return _year;}

    public void Setyear(int year)
    {this._year=year;}

    public String StudentToString()
    {
        return HumanToString()+"\nКурс: "+Getyear();
    }
    public void Print()
    {
        System.out.println("Имя: "+Getname()+" " +Getsurname()+"\n"+"Возраст: "+Getage()
        +", Курс: "+Getyear());
        Getaddress().Print();
    }
}
