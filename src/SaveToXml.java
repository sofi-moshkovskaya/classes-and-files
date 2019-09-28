import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SaveToXml {
    private String _url;

   public SaveToXml(String url)
    {
        this._url=url;
    }

    public HumanList LoadXml()
    {
        HumanList list=new HumanList();
        try {

            File xmlFile = new File(_url);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder biulder = factory.newDocumentBuilder();
            Document doc = biulder.parse(xmlFile);

            ParseXmlFile(doc, list);
        }
        catch (IOException | SAXException | ParserConfigurationException e){
            e.printStackTrace();
        }
        return list;

    }

    public void ParseXmlFile(Document doc, HumanList list)
    {

        NodeList teachernodelist = doc.getElementsByTagName("staff");
        if(teachernodelist!=null)
        {
            for(int i =0; i<teachernodelist.getLength(); i++)
            {
                Node node=teachernodelist.item(i);
                String T_name=((Element) node).getElementsByTagName("name").item(0).getTextContent();
                String T_surname=((Element) node).getElementsByTagName("surname").item(0).getTextContent();
                String T_age=((Element) node).getElementsByTagName("age").item(0).getTextContent();

                String T_country=((Element) node).getElementsByTagName("country").item(0).getTextContent();
                String T_city=((Element) node).getElementsByTagName("city").item(0).getTextContent();

                String T_studentcount=((Element) node).getElementsByTagName("studentcount").item(0).getTextContent();

                Address T_address=new Address(T_country,T_city);
                Teacher teacher=new Teacher(T_name,T_surname,Integer.parseInt(T_age), T_address, HumanType.Teacher,Integer.parseInt(T_studentcount));

                int studentcount=Integer.parseInt(T_studentcount);
                if(studentcount!=0)
                {
                    for(int j=0;j<studentcount;j++)
                    {

                        String S_name=((Element)teachernodelist.item(i)).getElementsByTagName("studentname").item(j).getTextContent();
                        String S_surname=((Element) teachernodelist.item(i)).getElementsByTagName("studentsurname").item(j).getTextContent();
                        String S_country=((Element) teachernodelist.item(i)).getElementsByTagName("studentcountry").item(j).getTextContent();
                        String S_city=((Element) teachernodelist.item(i)).getElementsByTagName("studentcity").item(j).getTextContent();
                        String S_age=((Element) teachernodelist.item(i)).getElementsByTagName("studentage").item(j).getTextContent();
                        String S_year=((Element) teachernodelist.item(i)).getElementsByTagName("studentyear").item(j).getTextContent();

                        Student student=new Student(S_name,S_surname,Integer.parseInt(S_age),new Address(S_country,S_city), HumanType.Student,Integer.parseInt(S_year));
                        teacher.AddToList(student);
                    }
                }

                list.add(teacher);
            }
        }
    }

}
