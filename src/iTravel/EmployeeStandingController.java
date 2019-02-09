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

public class EmployeeStandingController implements Initializable {


    //TABLE VIEW AND DATA
    private EmployeesAdapter employeesAdapter;

    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> FirstNameColumn;
    @FXML
    private TableColumn<Employee, String> LastNameColumn;
    @FXML
    private TableColumn<Employee, String> EmailAddressColumn;
    @FXML
    private TableColumn<Employee, String> JobColumn;
    @FXML
    private TableColumn<Employee, String> StatusColumn;

    final ObservableList<Employee> data = FXCollections.observableArrayList();

    public void setModel(EmployeesAdapter employees) {

        employeesAdapter = employees;
        buildData();

    }
    @FXML
    public void buildData() {
        try {
            data.addAll(employeesAdapter.getEmployeeList());
        } catch (SQLException ex) {
            // displayAlert("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
        EmailAddressColumn.setCellValueFactory(cellData -> cellData.getValue().EmailProperty());
        JobColumn.setCellValueFactory(cellData -> cellData.getValue().JobProperty());
        StatusColumn.setCellValueFactory(cellData -> cellData.getValue().StatusProperty());

        tableView.setItems(data);

    }

}
