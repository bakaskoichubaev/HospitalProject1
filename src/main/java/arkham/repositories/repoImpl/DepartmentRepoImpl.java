package arkham.repositories.repoImpl;

import arkham.models.Department;
import arkham.models.Doctor;
import arkham.repositories.DepartmentRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@RequiredArgsConstructor
@Repository
@Transactional
public class DepartmentRepoImpl implements DepartmentRepo {
    private final EntityManager entityManager;

    @Override
    public List<Department> findAll(Long id) {
        return entityManager.createQuery("select d from Department d join d.hospital f where f.id=:id",
                Department.class).setParameter("id",id).getResultList();
    }


    @Override
    @Transactional
    public void save(Department department) {
        entityManager.merge(department);
    }

    @Override
    public Department findById(Long departmentId) {
        return entityManager.find(Department.class, departmentId);
    }

    @Override
    public void update(Department department) {
        entityManager.merge(department);
    }

//    @Override
//    public void assignDepartment(Long doctorId, Long id) {
//        Doctor doctor = entityManager.find(Doctor.class, doctorId);
//        Department department = entityManager.find(Department.class, id);
//
//        doctor.addDepartment(department);
//        department.addDoctor(doctor);
//
//        entityManager.merge(doctor);
//        entityManager.merge(department);
//    }
}
