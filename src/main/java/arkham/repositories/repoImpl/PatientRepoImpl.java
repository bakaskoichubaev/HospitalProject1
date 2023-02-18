package arkham.repositories.repoImpl;

import arkham.models.Patient;
import arkham.repositories.PatientRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class PatientRepoImpl implements PatientRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Patient> findAll() {
        return entityManager.createQuery("select p from Patient p", Patient.class).getResultList();
    }
}
