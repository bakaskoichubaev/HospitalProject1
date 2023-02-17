package arkham.repositories;

import arkham.models.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Repository
public interface AppointmentRepo {
    List<Appointment> findAll();

}
