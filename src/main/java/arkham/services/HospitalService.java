package arkham.services;

import arkham.models.Department;
import arkham.models.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service
public interface HospitalService {
    List<Hospital> findAll();

    void save(Hospital hospital);

    void deleteHospital(Long hospitalId);

    Hospital getHospitalById(Long hospitalId);

    void update(Hospital hospital);
}
