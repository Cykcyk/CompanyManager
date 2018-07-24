package app.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personal_data")
public class PersonalData {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "job")
    private String job;

    @Column(name = "email_address")
    private String emailAddress;

    public PersonalData(Long id, String firstName, String lastName, String job, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalData)) return false;
        PersonalData that = (PersonalData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(job, that.job) &&
                Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, job, emailAddress);
    }

    public PersonalData() {
    }

    public PersonalData(String firstName, String lastName, String job, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getJob(){
        return this.job;
    }

    public void setJob(String job){
        this.job = job;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
