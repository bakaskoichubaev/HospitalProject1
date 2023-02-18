package arkham.services.serviceImpl;

import arkham.models.Department;
import arkham.models.Hospital;
import arkham.repositories.DepartmentRepo;
import arkham.repositories.HospitalRepo;
import arkham.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    private final HospitalRepo hospitalRepo;
    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public void save(Long id, Department department) {
        Hospital hospital = hospitalRepo.getHospitalById(id);
        for (Department department1 : departmentRepo.findAll()) {
            if (!department.getName().equals(department1.getName())){
                hospital.addDepartment(department);
                department.setHospital(hospital);
                departmentRepo.save(department);
            }
        }
    }
}
