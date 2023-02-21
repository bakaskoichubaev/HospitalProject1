package arkham.services.serviceImpl;

import arkham.exeptions.BudRequestExeption;
import arkham.models.Department;
import arkham.models.Hospital;
import arkham.repositories.DepartmentRepo;
import arkham.repositories.HospitalRepo;
import arkham.services.DepartmentService;
import arkham.services.HospitalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo;


    public DepartmentServiceImpl(DepartmentRepo departmentRepo, HospitalRepo hospitalRepo) {
        this.departmentRepo = departmentRepo;
        this.hospitalRepo = hospitalRepo;

    }

    @Override
    public List<Department> findAll(Long id) {
        return departmentRepo.findAll(id);
    }

    @Override
    public void save(Long hospitalId, Department department) throws BudRequestExeption {
        Hospital hospital = hospitalRepo.getHospitalById(hospitalId);
        for (Department dep : departmentRepo.findAll(hospital.getId())) {
            if (dep.getName().equals(department.getName())) {
                throw new BudRequestExeption();
            }
        }
        hospital.addDepartment(department);
        department.setHospital(hospital);
        departmentRepo.save(department);
    }


    @Override
    public Department findById(Long departmentId) {
        return departmentRepo.findById(departmentId);
    }

    @Override
    public void update(Department department) {
        departmentRepo.update(department);
    }
}
