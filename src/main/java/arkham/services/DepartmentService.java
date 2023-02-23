package arkham.services;

import arkham.models.Department;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service
public interface DepartmentService {
    List<Department> findAll(Long hospitalId);

    void save(Long id, Department department);

    Department findById(Long departmentId);

    void update(Long departmentId,Department department);


    void deletePatient(Long id);



}
