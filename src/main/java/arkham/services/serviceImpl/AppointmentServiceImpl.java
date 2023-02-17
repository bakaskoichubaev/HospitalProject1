package arkham.services.serviceImpl;

import arkham.models.Appointment;
import arkham.repositories.AppointmentRepo;
import arkham.services.AppointmentService;
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
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;
    @Override
    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }
}
