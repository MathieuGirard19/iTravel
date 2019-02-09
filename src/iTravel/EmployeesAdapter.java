package iTravel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesAdapter {

    Connection connection;

    public EmployeesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute("DROP TABLE EmployeeTable");
            } catch (SQLException ex) {
                System.out.println("error");
            } finally {
                stmt.execute("CREATE TABLE EmployeeTable ("
                        + "FirstName CHAR(15) NOT NULL PRIMARY KEY, "
                        + "LastName CHAR(15), " +
                        "Email CHAR(15), " + "Job CHAR(15),"+"Status CHAR(15)"+")");
                populateSamples();
            }
        }
    }

    private void populateSamples() throws SQLException {
        // Add some teams
        this.addEmployee("John","Mario", "uwo1", "Manager","Active");
        this.addEmployee("Matt", "Mario", "uwo2", "Manager","Active");
        this.addEmployee("Mike", "Mario", "uwo3", "Manager","Active");
        this.addEmployee("Milo", "Mario", "uwo4", "Manager","Active");
    }

    public void addEmployee (String first, String last, String email, String job, String status) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO EmployeeTable (FirstName, LastName, Email, Job, Status) VALUES ('" + first + "','"+last+"', '"+email+"','"+job+"','"+status+"')");
    }


    public void removeEmployee (String first,String last) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE EmployeeTable SET Status = 'Fired' WHERE (FirstName ='"+first+"' AND LastName = '"+last+"')");
    }
    public void updateEmployee (String first,String last, String email, String job, String status) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE EmployeeTable SET Email = '"+email+"'  WHERE (FirstName ='"+first+"' AND LastName = '"+last+"')");
        stmt.executeUpdate("UPDATE EmployeeTable SET Job = '"+job+"'  WHERE (FirstName ='"+first+"' AND LastName = '"+last+"')");
        stmt.executeUpdate("UPDATE EmployeeTable SET Status = '"+status+"'  WHERE (FirstName ='"+first+"' AND LastName = '"+last+"')");
    }
    public ObservableList<Employee> getEmployeeList() throws SQLException {
        ObservableList<Employee> list = FXCollections.observableArrayList();
        ResultSet rs;
        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM EmployeeTable";
        rs = stmt.executeQuery(sqlStatement);
        while (rs.next()) {
            list.add(new Employee(rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("Job"),
                    rs.getString("Status")));
        }
        return list;
    }
    public ObservableList<String> getEmployeeFullName() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;
        list.removeAll();
        Statement stmt = connection.createStatement();
        String str="SELECT * FROM EmployeeTable";
        rs = stmt.executeQuery(str);
        while (rs.next()){
            String FlightName = ""+ rs.getString("FirstName")+"_"+rs.getString("LastName");
            list.add(FlightName);
        }
        return list;
    }


    public ObservableList<String> getEmployeeLastName() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;
        list.removeAll();
        Statement stmt = connection.createStatement();
        String str="SELECT * FROM EmployeeTable";
        rs = stmt.executeQuery(str);
        while (rs.next()){
            String FlightName = rs.getString("LastName");
            list.add(FlightName);
        }
        return list;
    }

    public ObservableList<String> getEmployeeName() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;
        list.removeAll();
        Statement stmt = connection.createStatement();
        String str="SELECT * FROM EmployeeTable";
        rs = stmt.executeQuery(str);
        while (rs.next()){
            String FlightName = rs.getString("FirstName");
            list.add(FlightName);
        }
        return list;
    }

}
