package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateEmployeeController implements Initializable {

    @FXML
    Button SaveButton;

    @FXML
    Button CancelButton;

    @FXML
    TextField EmailAddress;

    @FXML
    TextField Job;

    @FXML
    TextField Status;

    @FXML
    ComboBox<String> EmployeeFirstNameComboBox;
    @FXML
    ComboBox<String> EmployeeLastNameComboBox;

    private EmployeesAdapter employeesAdapter;

    final ObservableList<String> data = FXCollections.observableArrayList();
    final ObservableList<String> data2 = FXCollections.observableArrayList();


    public void exit() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
    public void setModel(EmployeesAdapter employee){
        employeesAdapter=employee;
        buildComboBoxData();
    }
    public void buildComboBoxData() {
        try {
            data.addAll(employeesAdapter.getEmployeeName());
            EmployeeFirstNameComboBox.setItems(data);
            data2.addAll(employeesAdapter.getEmployeeLastName());
            EmployeeLastNameComboBox.setItems(data2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @FXML
    public void update() {
        try {
            employeesAdapter.updateEmployee(EmployeeFirstNameComboBox.getValue(), EmployeeLastNameComboBox.getValue(), EmailAddress.getText(), Job.getText(),Status.getText());
        } catch (SQLException ex) {
        }

        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
