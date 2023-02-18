package arkham.services;

import arkham.models.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service
public interface DepartmentService {
    List<Department> findAll();

    void save(Long id, Department department);
}
