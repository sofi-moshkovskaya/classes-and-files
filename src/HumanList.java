import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanList {
    private ArrayList<Teacher> _list=new ArrayList();
    private static int _amount=0;

    HumanList(Teacher h)
    {
        _list.add(h);
        _amount++;
    }

    HumanList()
    {
        _list=new ArrayList();
        _amount=0;
    }

    public String ToFile()
    {
        String s="";
        for(int i=0; i<_list.size();i++)
        {
            s+= _list.get(i).Gettype()+" № "+(i+1)+'\n'+_list.get(i).TeacherToString()+"\n\n";
            System.out.println(_list.get(i).Gettype()+" № "+(i+1));
            System.out.println(_list.get(i).TeacherToString());
            System.out.println("\n");
        }
        return s;
    }

    public int Getsize()
    {return _list.size(); }
   public List<Teacher> getList()
   {
        return _list;
    }
    public void add(Teacher h)
    {
        _list.add(h);
        _amount++;
    }

    public int find(String name)
    {
        int id=0;
        for(int i=0; i<_list.size(); i++)
        {
            if(_list.get(i).Getname().matches(name))
                id=i;
        }
        return id;
    }

    public void delete(Teacher h)
    {
        _list.remove(h);
        _amount--;
    }


    public void delete(int number)
    {
        _list.remove(number);
        _amount--;
    }

    public int Getamount()
    {
        return _amount;
    }
}
