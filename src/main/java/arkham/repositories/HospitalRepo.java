package arkham.repositories;

import arkham.models.Department;
import arkham.models.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Repository
public interface HospitalRepo {
    List<Hospital> findAll();

    void save(Hospital hospital);

    void deleteHospital(Long hospitalId);

    Hospital getHospitalById(Long hospitalId);


    void update(Hospital updateHospital);
}
