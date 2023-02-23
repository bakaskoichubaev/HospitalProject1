package arkham.api;

import arkham.App;
import arkham.models.Appointment;
import arkham.models.Patient;
import arkham.models.enums.Gender;
import arkham.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentApi {
    private final AppointmentService appointmentService;
    private final PatientService patientService;

    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    @GetMapping("/{hospitalId}")
    public String getAllAppointments(Model model, @PathVariable Long hospitalId){
        model.addAttribute("appointments",appointmentService.findAll(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "appointment/appointmentPage";
    }

    @GetMapping("/new/{hospitalId}")
    public String addAppointment(@PathVariable("hospitalId") Long hospitalId,
                                 Model model){
        Appointment appointment = new Appointment();
        model.addAttribute("newAppointment", appointment);
        model.addAttribute("patients",patientService.findAll(hospitalId));
        model.addAttribute("departments", departmentService.findAll(hospitalId));
        model.addAttribute("doctors", doctorService.getAllDoctors(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "appointment/saveAppointment";
    }

    @PostMapping("/save/{hospitalId}")
    public String save(@PathVariable Long hospitalId,
                       Appointment appointment){
        appointmentService.save(hospitalId,appointment);
        return "redirect:/appointments/" + hospitalId;
    }





















//    @GetMapping("{appointmentId}/edit")
//    public String edit(@PathVariable("appointmentId") Long appointmentId, Model model){
//        model.addAttribute("appointment", appointmentService.findById(appointmentId));
//        return "appointment/update";
//    }
//    @PostMapping("{id}/update")
//    public String update(@ModelAttribute("appointment")Appointment appointment){
//        appointmentService.update(appointment);
//        return "redirect:/appointments";
//    }

}
