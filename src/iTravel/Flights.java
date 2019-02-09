package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Flights {

    private final StringProperty Flight_number;
    private final StringProperty Airplane;
    private final IntegerProperty Seats;
    private final StringProperty Here;
    private final StringProperty There;
    private final StringProperty Status;

    public Flights(String number, String plane, int seats , String from, String to, String Status) {
        this.Flight_number = new SimpleStringProperty(number);
        this.Airplane = new SimpleStringProperty(plane);
        this.Seats = new SimpleIntegerProperty(seats);
        this.Here = new SimpleStringProperty(from);
        this.There = new SimpleStringProperty(to);
        this.Status = new SimpleStringProperty(Status);
    }


    public void setFlightNumber(String name) {
        Flight_number.set(name);
    }
    public StringProperty FlightNumberProperty() {
        return Flight_number;
    }
    public String getTemName() {
        return Flight_number.get();
    }

    public void setAirplaneType(String Model) {
        Airplane.set(Model);
    }
    public StringProperty AirplaneModelProperty() {
        return Airplane;
    }
    public String getAirplaneType() {
        return Airplane.get();
    }

    public void setNumberOfSeats(int seats) {
        Seats.set(seats);
    }
    public IntegerProperty NumberofSeatsProperty() {
        return Seats;
    }
    public int getNumberofSeats() {
        return Seats.get();
    }

    public void setOrigin(String Start) {Here.set(Start);
    }
    public StringProperty OriginProperty() {
        return Here;
    }
    public String getOrigin() {
        return Here.get();
    }


    public void setDestination(String Finish) { There.set(Finish); }
    public StringProperty DestinationProperty() {
        return There;
    }
    public String getDestination() {
        return There.get();
    }

    public void setStatus(String condition) {
        Status.set(condition);
    }
    public StringProperty StatusProperty() {
        return Status;
    }
    public String getStatus() {
        return Status.get();
    }

}
