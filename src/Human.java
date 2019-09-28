import java.util.Scanner;

public class Human {
    private String _name;
    private String _surname;
    private int _age;
    private HumanType _type;
    private Address _address;

    Human(String name, String surname, int age, String country, String city, HumanType type) {
        this._name=name;
        this._surname=surname;
        this._age=age;
        this._type=type;
        this._address=new Address(country,city);
    }

    Human(String name, String surname, int age, Address ad, HumanType type) {
        this._name=name;
        this._surname=surname;
        this._age=age;
        this._address=ad;
        this._type=type;
    }

    Scanner in=new Scanner(System.in);
    Human(int a)
    {
        System.out.print("\nВведите имя: ");
        this._name=in.next();
        System.out.print("Введите фамилию: ");
        this._surname=in.next();
        System.out.print("Введите возраст: ");
        this._age=in.nextInt();
        System.out.print("Введите страну: ");
        String country=in.next();
        System.out.print("Введите город: ");
        String city=in.next();
        this._address=new Address(country,city);
    }

    public String Getname()
    {return _name;}

    public String Getsurname()
    {return _surname;}

    public int Getage()
    {return _age;}

    public void Setname(String name)
    {this._name=name;}

    public void Setsurname(String surname)
    {this._surname=surname;}

    public void Setage(int age)
    {this._age=age;}

    public void Setaddress(String country, String city)
    {
        this._address=new Address(country,city);
    }

    public Address Getaddress(){return _address;}

    public HumanType Gettype()
    {
        return _type;
    }

    public String HumanToString()
    {
        return Gettype()+"\nИмя: "+Getname()+"\nФамилия: "+Getsurname()+"\nВозраст: "+Getage()+"\n"+_address.toString();
    }
    public void Print()
    {
        System.out.println("Имя: "+Getname()+"\n" +"Фамилия: "+Getsurname()+"\n"+"Возраст: "+Getage());
        _address.Print();
    }
}
