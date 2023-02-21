package arkham.repositories.repoImpl;

import arkham.models.Department;
import arkham.models.Doctor;
import arkham.repositories.DoctorRepo;
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
public class DoctorRepoImpl implements DoctorRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Doctor> getAllDoctors(Long id) {
        return entityManager.createQuery("select d from Doctor d join d.hospital f where f.id=:id",
                Doctor.class).setParameter("id",id).getResultList();
    }

    @Override
    public void save(Doctor doctor) {
        entityManager.merge(doctor);
    }

    @Override
    public Doctor findById(Long doctorId) {
        return entityManager.find(Doctor.class, doctorId);
    }

    @Override
    public void update(Doctor doctor) {
        entityManager.merge(doctor);
    }

    @Override
    public void assignDoctor(Long departmentId, Long doctorId) {
        Department department = entityManager.find(Department.class, departmentId);
        Doctor doctor = entityManager.find(Doctor.class, doctorId);

        department.addDoctor(doctor);
        doctor.addDepartment(department);
        entityManager.merge(department);
        entityManager.merge(doctor);
    }
}
