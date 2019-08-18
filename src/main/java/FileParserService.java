import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;

public abstract class FileParserService {

    public FileParserService() { } // constructor

    protected abstract FileParser getParser();

    public Note getNote(){
        try {

            FileParser fileParser = getParser();
            return fileParser.parse();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected abstract void setFileReader(File fileReader);


}
