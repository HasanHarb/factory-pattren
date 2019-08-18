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

public class XMLFileParser  implements  FileParser{
    Note note ;
    File reader ;

    XMLFileParser(){ } // constructor

    XMLFileParser(File reader){
        this.reader = reader ;
    } // constructor

    @Override
    public Note parse() throws ParserConfigurationException {
        this.note = new Note();
        try {
            // read and parser XML File
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = (Document) dBuilder.parse(reader);

            doc.getDocumentElement().normalize();

            NodeList noteList = doc.getElementsByTagName("note"); // Return all items labeled "note"
            Node noteNode = noteList.item(0); // The first element note

            if (noteNode.getNodeType() == Node.ELEMENT_NODE) {

                Element noteElement = (Element) noteNode;
                this.note.setTo((String) noteElement.getElementsByTagName("to").item(0).getTextContent());
                this.note.setFrom((String) noteElement.getElementsByTagName("from").item(0).getTextContent());
                this.note.setHeading((String) noteElement.getElementsByTagName("heading").item(0).getTextContent());
                this.note.setBody((String) noteElement.getElementsByTagName("body").item(0).getTextContent());

            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.note;
    }
}
