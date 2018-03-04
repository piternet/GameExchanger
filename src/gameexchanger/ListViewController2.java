package gameexchanger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController2 implements Initializable {
    @FXML
    private ListView<String> listView2;
    private ObservableList<String> observableList;

    private void setListView() {
        observableList = listView2.getItems();
        DBController dbController = new DBController();
        JSONObject jsonObject = dbController.getFromDatabase();
        for (Object key : jsonObject.keySet()) {
            observableList.add((String) key);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListView();
    }
}
