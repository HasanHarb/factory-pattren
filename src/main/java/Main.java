import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;


public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        File folder = new File(".");
        String resources = folder.getCanonicalPath() + "\\src\\main\\resources\\"; // get path folder project

        FileParserService JSONParse = new JSONFileParserService();
        FileParserService XMLParse = new XMLFileParserService();

        System.out.println("JSON Parser :)");
        try {
            File reader = new File(resources + "json_file.json");
                JSONParse.setFileReader(reader);
                Note note = JSONParse.getNote();
                System.out.println(note.getTo());
                System.out.println(note.getFrom());
                System.out.println(note.getHeading());
                System.out.println(note.getBody());
                System.out.println("------------------");

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("XML Parser :)");
        try {
            File reader = new File(resources + "xml_file.xml");
                XMLParse.setFileReader(reader);
                Note note = XMLParse.getNote();
                System.out.println(note.getTo());
                System.out.println(note.getFrom());
                System.out.println(note.getHeading());
                System.out.println(note.getBody());
                System.out.println("------------------");

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
