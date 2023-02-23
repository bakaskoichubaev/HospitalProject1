package arkham.repositories.repoImpl;

import arkham.models.Department;
import arkham.models.Doctor;
import arkham.repositories.DepartmentRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
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
    public List<Department> findAll(Long hospitalId) {
        return entityManager.createQuery("SELECT d FROM Department d JOIN d.hospital h WHERE h.id = :id",
                Department.class).setParameter("id",hospitalId).getResultList();
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
    public void update(Long departmentId, Department department) {
        Department department1 = entityManager.find(Department.class, departmentId);
        department1.setName(department.getName());
        entityManager.merge(department1);
    }

    @Override
    public void delete(Long id) {
        Department department = entityManager.find(Department.class, id);
        department.setHospital(null);
        entityManager.remove(department);
    }

}
