import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONFileParser implements FileParser {
    Note note ;
    JSONParser parser;
    File reader ;

    JSONFileParser(){ } // constructor

    JSONFileParser(File reader){
        this.reader = reader ;
    } // constructor

    @Override
    public Note parse() {
        this.note = new Note();
        JSONParser parser = new JSONParser();
        try{
            // read and parser JSON file
            Object JSONfileObject = parser.parse(new FileReader(reader.getPath()));
            JSONObject jsonObject = (JSONObject) JSONfileObject; // casting Object to JSONObject

            JSONObject noteJson = (JSONObject) jsonObject.get("note"); // get object note
            this.note.setFrom((String) noteJson.get("from"));
            this.note.setTo((String) noteJson.get("to"));
            this.note.setHeading((String) noteJson.get("heading"));
            this.note.setBody((String) noteJson.get("body"));

        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.note; // return note object
    }



}
