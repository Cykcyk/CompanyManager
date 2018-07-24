package app.controller;

import app.dao.PersonalData;
import app.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companyManager")
public class PersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public PersonalDataResource getPersonalData(@PathVariable Long id) {
        PersonalData personalData = personalDataService.getPersonalData(id);

        return new PersonalDataResource(personalData.getFirstName(),
                personalData.getLastName(), personalData.getJob(), personalData.getEmailAddress());
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public void deletePersonalData(@PathVariable Long id) {
        personalDataService.deletePersonalData(id);
    }

    @RequestMapping(value = "/employees/", method = RequestMethod.POST)
    public void addPersonalData(@RequestBody PersonalDataResource personalDataResource) {
        personalDataService.addPersonalData(personalDataResource);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updatePersonalData(@PathVariable Long id, @RequestBody PersonalDataResource personalDataResource) {
        personalDataService.updatePersonalData(id, personalDataResource);
    }

    @RequestMapping(value = "/employees/", method = RequestMethod.GET)
    public List<PersonalDataResource> getListOfPersonalData(@RequestParam(value = "firstName", required = false) List<String> firstName,
                                                            @RequestParam(value = "lastName", required = false) List<String> lastName,
                                                            @RequestParam(value = "job", required = false) List<String> job,
                                                            @RequestParam(value = "emailAddress", required = false) List<String> emailAddress) {
        return personalDataService.getListOfPersonalData(firstName, lastName, job, emailAddress);
    }

    @RequestMapping(value = "/jobs/", method = RequestMethod.GET)
    public List getJobsList(){
        return personalDataService.getJobsList();
    }
}
