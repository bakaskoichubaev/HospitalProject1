package arkham.services.serviceImpl;

import arkham.models.Doctor;
import arkham.models.Hospital;
import arkham.repositories.DoctorRepo;
import arkham.repositories.HospitalRepo;
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

    private final HospitalRepo hospitalRepo;

    @Override
    public List<Doctor> getAllDoctors(Long id) {
        return doctorRepo.getAllDoctors(id);
    }

    @Override
    public void save(Long hospitalId, Doctor doctor) {
        Hospital hospital = hospitalRepo.getHospitalById(hospitalId);
        hospital.addDoctor(doctor);
        doctor.setHospital(hospital);
        doctorRepo.save(doctor);
    }

    @Override
    public Doctor findById(Long doctorId) {
        return doctorRepo.findById(doctorId);
    }

    @Override
    public void update(Doctor doctor) {
        doctorRepo.update(doctor);
    }

    @Override
    public void assignDoctor(Long departmentId, Long doctorId) {
        doctorRepo.assignDoctor(departmentId, doctorId);
    }
}
