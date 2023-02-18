package arkham.services.serviceImpl;

import arkham.models.Doctor;
import arkham.repositories.DoctorRepo;
import arkham.services.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.getAllDoctors();
    }
}
