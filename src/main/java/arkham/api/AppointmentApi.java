package arkham.api;

import arkham.models.Appointment;
import arkham.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller
@RequestMapping("/appointment/appointments")
@RequiredArgsConstructor
public class AppointmentApi {
    private final AppointmentService appointmentService;

    @GetMapping
    public String getAllAppointments(Model model){
        List<Appointment> appointments = appointmentService.findAll();
        model.addAttribute("appointments",appointments);
        return "appointments";
    }

}
