package arkham.repositories.repoImpl;

import arkham.models.Department;
import arkham.repositories.DepartmentRepo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Department> findAll() {
        return entityManager.createQuery("select d from Department d",Department.class).getResultList();
    }

    @Override
    public void save(Department department) {
        entityManager.persist(department);
    }
}
