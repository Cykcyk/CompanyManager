package app.dao;

import java.util.List;

class PersonalDataQueryBuilder {

    private List <String> firstName;
    private List <String> lastName;
    private List <String> job;
    private List <String> emailAddress;

    PersonalDataQueryBuilder(List<String> firstName, List<String> lastName, List<String> job, List<String> emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.emailAddress = emailAddress;
    }

    String buildQuery() {
        String firstNameQuery, lastNameQuery, jobQuery, emailAddressQuery;
        StringBuilder string = new StringBuilder();

        if (this.firstName != null){
            firstNameQuery = "firstName in :firstNames";
            string.append(firstNameQuery);
        }
        if (this.lastName != null){
            lastNameQuery = "lastName in :lastNames";
            if (this.firstName != null){
                string.append(" and ");
            }
            string.append(lastNameQuery);
        }
        if (this.job != null){
            jobQuery = "job in :jobs ";
            if (this.firstName != null || this.lastName != null){
                string.append(" and ");
            }
            string.append(jobQuery);
        }

        if (this.emailAddress != null){
            emailAddressQuery = "emailAddress in :emailAddresses";
            if (this.firstName != null || this.lastName != null || this.job != null){
                string.append(" and ");
            }
            string.append(emailAddressQuery);
        }
        return string.toString();
    }
}
