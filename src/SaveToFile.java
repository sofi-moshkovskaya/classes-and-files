import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    private String _url;

    SaveToFile(String url)
    {this._url=url;}

    public void SaveToTxt(String result)
    {
        try{
            FileWriter file = new FileWriter(_url, true);
            file.write(result);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
