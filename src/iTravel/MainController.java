/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iTravel;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Abdelkader
 */
public class MainController implements Initializable {

    @FXML
    private MenuBar mainMenu;
    private Connection conn;
    private FlightsAdapter flight;
    private EmployeesAdapter employee;


    @FXML
    public void showFlights() throws Exception {
        // create Teams model
        flight = new FlightsAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("standingFlight.fxml"));
        Parent standingFlights = (Parent) fxmlLoader.load();
        standingFlightController FlightsStandingController = (standingFlightController) fxmlLoader.getController();
        FlightsStandingController.setModel(flight);
        Scene scene = new Scene(standingFlights);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Total Flights");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    public void AddFlight() throws Exception {

        flight = new FlightsAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddFlight.fxml"));
        Parent AddFlight = (Parent) fxmlLoader.load();
        AddFlightController addFlightController = (AddFlightController) fxmlLoader.getController();
        addFlightController.setModel(flight);

        Scene scene = new Scene(AddFlight);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Add Flight");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }
    @FXML
    public void RemoveFlight() throws Exception {
        flight = new FlightsAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveFlight.fxml"));
        Parent removeFlight = (Parent) fxmlLoader.load();
        RemoveFlightController removeFlightController = (RemoveFlightController) fxmlLoader.getController();
        removeFlightController.setModel(flight);
        Scene scene = new Scene(removeFlight);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Remove Flight");
        stage.show();
    }
    @FXML
    public void showEmployee() throws Exception {
        employee = new EmployeesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeStanding.fxml"));
        Parent standingEmployee = (Parent) fxmlLoader.load();
        EmployeeStandingController employeeStandingController = (EmployeeStandingController) fxmlLoader.getController();
        employeeStandingController.setModel(employee);
        Scene scene = new Scene(standingEmployee);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Total Employee");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    public void AddEmployee() throws Exception {
        employee = new EmployeesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeAdder.fxml"));
        Parent EmployeeAdder = (Parent) fxmlLoader.load();
        AddEmployeeController addEmployeeController = (AddEmployeeController) fxmlLoader.getController();
        addEmployeeController.setModel(employee);
        Scene scene = new Scene(EmployeeAdder);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Add Employee");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    public void RemoveEmployee() throws Exception {
        employee = new EmployeesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveEmployee.fxml"));
        Parent removeEmployee = (Parent) fxmlLoader.load();
        RemoveEmployeeController removeEmployeeController = (RemoveEmployeeController) fxmlLoader.getController();
        removeEmployeeController.setModel(employee);
        Scene scene = new Scene(removeEmployee);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Remove Employee");
        stage.show();
    }
    @FXML
    public void UpdateEmployee() throws Exception {
        employee = new EmployeesAdapter(conn, false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateEmployee.fxml"));
        Parent updateEmployee = (Parent) fxmlLoader.load();
        UpdateEmployeeController updateEmployeeController = (UpdateEmployeeController) fxmlLoader.getController();
        updateEmployeeController.setModel(employee);
        Scene scene = new Scene(updateEmployee);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("Update Employee");
        stage.show();
    }
    public void exit() {

        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void resetDB() {
        try {
            flight = new FlightsAdapter(conn, true);
            employee = new EmployeesAdapter(conn, true);

        } catch (SQLException ex) {
        }
    }
    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            String DB_URL = "jdbc:derby:iTravel;create=true";
            conn = DriverManager.getConnection(DB_URL);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}


