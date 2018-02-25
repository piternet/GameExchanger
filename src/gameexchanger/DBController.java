package gameexchanger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.*;

public class DBController {
    private static String FILENAME = "db.json";

    private File dbFile;
    private FileInputStream in;
    private FileOutputStream out;

    public DBController() throws IOException {
        dbFile = new File(FILENAME);
        if (!dbFile.exists()) {
            dbFile.createNewFile();
        }
        in = new FileInputStream(FILENAME);
        out = new FileOutputStream(FILENAME);
    }

    public void writeToFile(String text) throws IOException {
        out.write(text.getBytes());
    }

    public void addToDatabase(JSONObject jsonToAdd) {
        
    }

}
