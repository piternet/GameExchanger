package gameexchanger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {
    @FXML
    private ListView<String> listView;
    private ObservableList<String> observableList;

    private void setListView() {
        observableList = listView.getItems();
        try {
            String content = DBController.readFile("game.json");
            JSONObject jsonObject = new JSONObject(content);
            for (Object key : jsonObject.keySet()) {
                observableList.add((String) key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListView();
    }
}
