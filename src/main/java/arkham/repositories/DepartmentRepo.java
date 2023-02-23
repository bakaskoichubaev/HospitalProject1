package arkham.repositories;

import arkham.models.Department;
import arkham.models.Hospital;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Repository
public interface DepartmentRepo {
    List<Department> findAll(Long hospitalId);

    void save(Department department);

    Department findById(Long departmentId);

    void update(Long departmentId,Department department);


    void delete(Long id);



}
