package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.App;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.Complain;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.SpecialItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import static il.ac.haifa.cs.sweng.OCSFSimpleChat.SimpleClient.msgObject;

public class SpecialOrdersCustomerServiceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label totalOrdersLabel;

    @FXML
    private VBox vbox;

    private final List<SpecialItem> specialItems = (List<SpecialItem>) msgObject.getObject();

    @FXML
    void handleHome() throws IOException {
        App.setRoot("primaryCustomerService", "/Image/mainPageIcon.png", "Lilac");
    }

    @FXML
    void initialize() throws IOException{
        int size = 0;

        if(specialItems != null) {
            for (SpecialItem specialItem : specialItems) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(App.class.getResource("specialOrderItemCustomerService.fxml"));
                Node node = fxmlLoader.load();
                SpecialOrderItemCustomerServiceController specialOrderItemCustomerServiceController = fxmlLoader.getController();
                specialOrderItemCustomerServiceController.setData(specialItem);
                vbox.getChildren().add(node);
            }
            size = specialItems.size();
        }

        totalOrdersLabel.setText("Total special items: " + size);
    }
}