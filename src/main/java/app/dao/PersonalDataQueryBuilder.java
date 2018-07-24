package app.dao;

import com.google.common.base.Joiner;

import java.util.List;

class PersonalDataQueryBuilder {

    private List <String> firstNames;
    private List <String> lastNames;
    private List <String> jobs;
    private List <String> emailAddresses;

    PersonalDataQueryBuilder(List<String> firstNames, List<String> lastNames, List<String> jobs, List<String> emailAddresses) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.jobs = jobs;
        this.emailAddresses = emailAddresses;
    }

    String buildQuery() {
        String firstNameQuery = null, lastNameQuery = null, jobQuery = null, emailAddressQuery = null;

        if (this.firstNames != null){
            firstNameQuery = "firstName in :firstNames";
        }

        if (this.lastNames != null){
            lastNameQuery = "lastName in :lastNames";
        }

        if (this.jobs != null){
            jobQuery = "job in :jobs ";
        }

        if (this.emailAddresses != null){
            emailAddressQuery = "emailAddress in :emailAddresses";
        }

        return sql("SELECT pd FROM PersonalData pd ", and(firstNameQuery, lastNameQuery, jobQuery, emailAddressQuery));
    }

    private String and(String firstNameQuery, String lastNameQuery, String jobQuery, String emailAddressQuery){
        return Joiner.on(" AND ").skipNulls().join(firstNameQuery, lastNameQuery, jobQuery, emailAddressQuery);
    }

    private String sql(String sql, String parameters){
        if(parameters.isEmpty()){
            parameters = null;
        }
        return Joiner.on(" WHERE ").skipNulls().join(sql, parameters);
    }
}
