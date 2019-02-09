
package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {

    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty Email_Address;
    private final StringProperty Job;
    private final StringProperty Status;

    public Employee(String name, String lastName, String email, String position, String status) {
        this.FirstName = new SimpleStringProperty(name);
        this.LastName = new SimpleStringProperty(lastName);
        this.Email_Address = new SimpleStringProperty(email);
        this.Job = new SimpleStringProperty(position);
        this.Status = new SimpleStringProperty(status);
    }


    public void setName(String name) {
        FirstName.set(name);
    }
    public StringProperty NameProperty() {
        return FirstName;
    }
    public String getName() {
        return FirstName.get();
    }

    public void setLastName(String lastName) {
        LastName.set(lastName);
    }
    public StringProperty LastNameProperty() {
        return LastName;
    }
    public String getLastName() {
        return LastName.get();
    }

    public void setEmail(String email) {
        Email_Address.set(email);
    }
    public StringProperty EmailProperty() {
        return Email_Address;
    }
    public String getEmail() {
        return Email_Address.get();
    }

    public void setJob(String condition) { Job.set(condition);}
    public StringProperty JobProperty() {
        return Job;
    }
    public String getJob() {
        return Job.get();
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
