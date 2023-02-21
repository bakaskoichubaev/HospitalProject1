package arkham.services;

import arkham.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Service

public interface AppointmentService {
    List<Appointment> findAll();

    Appointment findById(Long appointmentId);

    void update(Appointment appointment);

}
