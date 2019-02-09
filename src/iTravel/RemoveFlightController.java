package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RemoveFlightController implements Initializable {

    @FXML
    Button CancelButton;

    @FXML
    Button RemoveButton;

    @FXML
    ComboBox<String> FlightComboBox;

    private FlightsAdapter flightsAdapter;
    final ObservableList<String> data = FXCollections.observableArrayList();


    public void setModel(FlightsAdapter flight){
        flightsAdapter=flight;
        buildComboBoxData();
    }
    public void buildComboBoxData() {
        try {
            data.addAll(flightsAdapter.getFlightNumbers());
            FlightComboBox.setItems(data);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @FXML
    public void Remove() throws SQLException {

        String str = FlightComboBox.getValue();
        flightsAdapter.removeFlight(str);
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void exit() {
        Stage stage = (Stage) RemoveButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
