package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class standingFlightController implements Initializable {


        //TABLE VIEW AND DATA
        private FlightsAdapter flightAdapter;

        @FXML
        private TableView<Flights> tableView;
        @FXML
        private TableColumn<Flights, String> FlightNumberColumn;
        @FXML
        private TableColumn<Flights, String> PlaneColumn;
        @FXML
        private TableColumn<Flights, Integer> seatsColumn;
        @FXML
        private TableColumn<Flights, String> HereColumn;
        @FXML
        private TableColumn<Flights, String> ThereColumn;
        @FXML
        private TableColumn<Flights, String> StatusCol;

    final ObservableList<Flights> data = FXCollections.observableArrayList();

    public void setModel(FlightsAdapter flights) {
        flightAdapter = flights;
        buildData();
    }
    @FXML
    public void buildData() {
        try {
            data.addAll(flightAdapter.getFlightsList());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FlightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().FlightNumberProperty());
        PlaneColumn.setCellValueFactory(cellData -> cellData.getValue().AirplaneModelProperty());
        seatsColumn.setCellValueFactory(cellData -> cellData.getValue().NumberofSeatsProperty().asObject());
        HereColumn.setCellValueFactory(cellData -> cellData.getValue().OriginProperty());
        ThereColumn.setCellValueFactory(cellData -> cellData.getValue().DestinationProperty());
        StatusCol.setCellValueFactory(cellData -> cellData.getValue().StatusProperty());

        tableView.setItems(data);

    }

}
