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
    List<Doctor> getAllDoctors();
}
