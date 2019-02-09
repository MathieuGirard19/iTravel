package iTravel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFlightController implements Initializable {

    @FXML
    Button SaveButton;

    @FXML
    Button CancelButton;

    @FXML
    TextField FlightNumber;

    @FXML
    TextField Airplane;

    @FXML
    TextField Seats;

    @FXML
    TextField Here;

    @FXML
    TextField There;

    @FXML
    TextField Status;

    FlightsAdapter flightsAdapter;

    public void setModel(FlightsAdapter flights) {
        flightsAdapter = flights;
    }

    public void exit() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void save() {
        try {
            flightsAdapter.addFlight(FlightNumber.getText(), Airplane.getText(), Integer.parseInt(Seats.getText()), Here.getText(), There.getText(),Status.getText());
        } catch (SQLException ex) {
        }

        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
