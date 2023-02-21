package arkham.repositories;

import arkham.models.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Repository
public interface DoctorRepo {
    List<Doctor> getAllDoctors(Long id);

    void save(Doctor doctor);

    Doctor findById(Long doctorId);

    void update(Doctor doctor);

    void assignDoctor(Long departmentId, Long doctorId);
}
