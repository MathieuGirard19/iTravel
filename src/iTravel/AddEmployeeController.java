package iTravel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {

    @FXML
    Button CancelButton;
    @FXML
    Button SaveButton;
    @FXML
    TextField FirstName;
    @FXML
    TextField LastName;
    @FXML
    TextField Email;
    @FXML
    TextField Job;
    @FXML
    TextField Status;


    private EmployeesAdapter employeesAdapter;

    public void setModel(EmployeesAdapter team) {
        employeesAdapter = team;
    }

    public void exit() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void save() {
        try {
            employeesAdapter.addEmployee(FirstName.getText(), LastName.getText(), Email.getText(), Job.getText(),Status.getText());
        } catch (SQLException ex) {
        }

        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
