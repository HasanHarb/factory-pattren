import java.io.File;
import java.io.FileReader;

public class XMLFileParserService extends FileParserService{
    File reader ;

    XMLFileParserService(){ } // constructor

    XMLFileParserService(File reader){
        this.reader = reader;
    } // constructor

    @Override
    protected FileParser getParser() {
        return new XMLFileParser(this.reader);
    }

    @Override
    protected void setFileReader(File fileReader) {
        this.reader = fileReader;
    }

}
