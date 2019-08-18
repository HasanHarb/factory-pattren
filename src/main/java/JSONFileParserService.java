import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class JSONFileParserService extends FileParserService {
    File reader ;

    JSONFileParserService(){ }

    JSONFileParserService(File reader){
        this.reader = reader;
    }

    @Override
    protected FileParser getParser() {
        return new JSONFileParser(this.reader);
    }

    @Override
    protected void setFileReader(File fileReader) {
        this.reader = fileReader;
    }
}

