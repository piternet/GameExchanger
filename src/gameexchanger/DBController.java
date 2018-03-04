package gameexchanger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.oracle.tools.packager.IOUtils;
import org.json.*;

public class DBController {
    private static String FILENAME = "db.json";

    private File dbFile;
    private FileInputStream in;
    private FileOutputStream out;

    public DBController()  {
        try {
            dbFile = new File(FILENAME);
            if (!dbFile.exists()) {
                dbFile.createNewFile();
            }
            //in = new FileInputStream(FILENAME);
            //out = new FileOutputStream(FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void writeToFile(String text) {
//        try {
//            out.write(text.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static String readFile(String path) throws IOException {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            /* Instead of using default, pass in a decoder. */
            return Charset.defaultCharset().decode(bb).toString();
        }
        finally {
            stream.close();
        }
    }

    public JSONObject getFromDatabase() {
        JSONObject jsonObject = null;
        try {
            String content = readFile(FILENAME);
            jsonObject = new JSONObject(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public void addToDatabase(JSONObject jsonToAdd) {

    }

}
