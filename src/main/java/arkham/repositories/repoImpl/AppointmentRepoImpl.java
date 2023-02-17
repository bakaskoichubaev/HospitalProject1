package arkham.repositories.repoImpl;

import arkham.models.Appointment;
import arkham.repositories.AppointmentRepo;
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
public class AppointmentRepoImpl implements AppointmentRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Appointment> findAll() {
        return entityManager.createQuery("select a from Appointment a", Appointment.class).getResultList();
    }
}
