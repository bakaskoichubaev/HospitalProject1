package arkham.services.serviceImpl;

import arkham.models.Appointment;
import arkham.models.Hospital;
import arkham.repositories.AppointmentRepo;
import arkham.repositories.DepartmentRepo;
import arkham.repositories.DoctorRepo;
import arkham.repositories.PatientRepo;
import arkham.services.AppointmentService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final DepartmentRepo departmentRepo;
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
    private final EntityManager entityManager;
    @Override
    public List<Appointment> findAll(Long id) {
        return appointmentRepo.findAll(id);
    }

    @Override
    public Appointment findById(Long appointmentId) {
        return appointmentRepo.findById(appointmentId);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentRepo.update(appointment);
    }

    @Transactional
    @Override
    public void save(Long hospitalId, Appointment appointment) {
        Hospital hospital = entityManager.find(Hospital.class, hospitalId);
        Appointment newAppointment=new Appointment();
        newAppointment.setId(appointment.getId());
        newAppointment.setDate(appointment.getDate());
        hospital.addAppointment(appointment);
        newAppointment.setDoctor(doctorRepo.findById(appointment.getDoctorId()));
        newAppointment.setDepartment(departmentRepo.findById(appointment.getDepartmentId()));
        newAppointment.setPatient(patientRepo.findById(appointment.getPatientId()));


        appointmentRepo.save(appointment);
    }
}
