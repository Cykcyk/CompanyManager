package app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        String queryString = new PersonalDataQueryBuilder(firstNames, lastNames, jobs, emailAddresses).buildQuery();
        Query query =entityManager.createQuery(queryString);
        if (firstNames != null){
            query.setParameter("firstNames", firstNames);
        }

        if (lastNames != null){
            query.setParameter("lastNames", lastNames);
        }

        if (jobs != null){
            query.setParameter("jobs", jobs);
        }

        if (emailAddresses != null){
            query.setParameter("emailAddresses", emailAddresses);
        }
        return query.getResultList();
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
