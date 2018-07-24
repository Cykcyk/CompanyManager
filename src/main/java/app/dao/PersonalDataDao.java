package app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PersonalDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonalData getPersonalData(Long id) {
        return entityManager.find(PersonalData.class, id);
    }

    public void update(PersonalData personalData) {
        entityManager.merge(personalData);
    }

    public List getPersonalDataList(List<String> firstNames, List<String> lastNames, List<String> jobs, List<String> emailAddresses) {
        String query = new PersonalDataQueryBuilder(firstNames, lastNames, jobs, emailAddresses).buildQuery();


        return entityManager.createQuery("select pd from PersonalData pd where " + query)
                .setParameter("firstNames", firstNames).setParameter("lastNames", lastNames)
                .setParameter("jobs", jobs).setParameter("emailAddresses", emailAddresses).getResultList();

    }

    public void deletePersonalData(Long id) {
        entityManager.remove(getPersonalData(id));
    }

    public void addPersonalData(PersonalData personalData) {
        entityManager.persist(personalData);
    }

    public List getJobsList() {
        return entityManager.createQuery("select count(id), job from PersonalData group by job").getResultList();
    }
}
