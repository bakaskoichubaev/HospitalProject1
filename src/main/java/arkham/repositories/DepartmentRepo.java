package arkham.repositories;

import arkham.models.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Repository
public interface DepartmentRepo {
    List<Department> findAll();

    void save(Department department);

}
