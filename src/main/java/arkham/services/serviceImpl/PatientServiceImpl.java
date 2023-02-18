package arkham.services.serviceImpl;

import arkham.models.Patient;
import arkham.repositories.PatientRepo;
import arkham.services.PatientService;
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
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }
}
