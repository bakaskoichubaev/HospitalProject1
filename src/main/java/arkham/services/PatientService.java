package arkham.services;

import arkham.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service
public interface PatientService {
    List<Patient> findAll();
}
