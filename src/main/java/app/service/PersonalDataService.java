package app.service;


import app.controller.PersonalDataResource;
import app.dao.PersonalData;
import app.dao.PersonalDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonalDataService {

    @Autowired
    PersonalDataDao personalDataDao;

    public PersonalData getPersonalData(Long id) {
        return personalDataDao.getPersonalData(id);
    }

    public void deletePersonalData(Long id) {
        personalDataDao.deletePersonalData(id);
    }

    public void addPersonalData(PersonalDataResource personalDataResource) {
        PersonalData personalData = new PersonalData(personalDataResource.getFirstName(), personalDataResource.getLastName(),
                personalDataResource.getJob(), personalDataResource.getEmailAddress());

        personalDataDao.addPersonalData(personalData);
    }

    public void updatePersonalData(Long id, PersonalDataResource personalDataResource) {
        PersonalData personalData = new PersonalData(id,personalDataResource.getFirstName(), personalDataResource.getLastName(),
                personalDataResource.getJob(), personalDataResource.getEmailAddress());

        PersonalData oldPersonalData = personalDataDao.getPersonalData(id);
        if(!oldPersonalData.equals(personalData)){
            personalDataDao.update(personalData);
        }
    }

    public List<PersonalDataResource> getListOfPersonalData(List<String> firstName, List<String> lastName, List<String> job, List<String> emailAddress) {
        List<PersonalData> personalDataList =  personalDataDao.getPersonalDataList(firstName, lastName, job, emailAddress);
        List<PersonalDataResource> personalDataResourceList = new ArrayList<>();
        for(PersonalData i: personalDataList){
            personalDataResourceList.add(new PersonalDataResource(i));
        }
        return personalDataResourceList;
    }

    public List getJobsList(){
        return personalDataDao.getJobsList();
    }
}
