package iTravel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightsAdapter {

    Connection connection;

    public FlightsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute("DROP TABLE FlightsTable");
            } catch (SQLException ex) {
                System.out.println("error");
            } finally {
                stmt.execute("CREATE TABLE FlightsTable ("
                        + "flight_number CHAR(15) NOT NULL PRIMARY KEY, "
                        + "airplane CHAR(15), " + "seats INT, "+"" +
                        "departure CHAR(15), " + "arrival CHAR(15)," + "Status CHAR (15)"+")");
                populateSamples();
            }
        }
    }

    private void populateSamples() throws SQLException {
        this.addFlight("Joe ","1", 10,"London", "Toronto","Active");
        this.addFlight("Matt", "2", 11,"London", "Toronto","Active");
        this.addFlight("Sprite", "3", 12,"London", "Toronto","Active");
        this.addFlight("Water", "4", 13,"London", "Toronto","Active");
    }

    public void addFlight(String number, String type,int numberOf_seats, String here, String there, String status) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO FlightsTable (flight_number, airplane, seats, departure, arrival, Status) VALUES ('" + number + "','"+type+"', "+numberOf_seats+" , '"+here+"','"+there+"','"+status+"')");
    }
    public void removeFlight(String number) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE FlightsTable SET Status = 'Inactive' WHERE flight_number ='"+number+"'");

    }

    public ObservableList<String> getFlightNumbers() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;
        list.removeAll();
        String str="SELECT * FROM FlightsTable";
        Statement stmt = connection.createStatement();
        rs = stmt.executeQuery(str);
        while (rs.next()){
            String FlightName = rs.getString("flight_number");
            list.add(FlightName);
        }
        return list;
    }

    public ObservableList<Flights> getFlightsList() throws SQLException {
        ObservableList<Flights> list = FXCollections.observableArrayList();
        ResultSet rs;
        String sqlStatement = "SELECT * FROM FlightsTable";
        Statement stmt = connection.createStatement();
        rs = stmt.executeQuery(sqlStatement);
        while (rs.next()) {
            list.add(new Flights(rs.getString("flight_number"),
                    rs.getString("airplane"),
                    rs.getInt("seats"),
                    rs.getString("departure"),
                    rs.getString("arrival"),
                    rs.getString("Status")));
        }
        return list;
    }




}
