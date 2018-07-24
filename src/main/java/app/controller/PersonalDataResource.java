package app.controller;

import app.dao.PersonalData;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PersonalDataResource {

    private String firstName;
    private String lastName;
    private String job;
    private String emailAddress;

    PersonalDataResource(String firstName, String lastName, String job, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.emailAddress = emailAddress;
    }

    public PersonalDataResource() {
    }

    public PersonalDataResource(PersonalData i) {
        this.firstName = i.getFirstName();
        this.lastName = i.getLastName();
        this.job = i.getJob();
        this.emailAddress = i.getEmailAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
