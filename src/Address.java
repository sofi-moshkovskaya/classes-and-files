public class Address {
    private String _country;
    private String _city;

    Address(String country,String city)
    {
        this._country=country;
        this._city=city;
    }
    public String Getcountry() {return _country;}

    public String Getcity() {return _city;}

    public void Setcountry(String country) {

        this._country = country;
    }


    public void Setcity(String city){
        this._city=city;
    }

    public void Setaddress(String country, String city)
    {Setcountry(country);
    Setcity(city);}

    public String toString()
    {
        return "Адрес: "+Getcountry()+", "+Getcity();
    }

    public void Print()
    {
        System.out.println("Адрес: "+Getcountry()+", "+Getcity());
    }
}
