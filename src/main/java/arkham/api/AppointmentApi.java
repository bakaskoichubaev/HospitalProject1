package arkham.api;

import arkham.models.Appointment;
import arkham.services.AppointmentService;
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

    @GetMapping("{hospitalId}")
    public String getAllAppointments(Model model, @PathVariable Long hospitalId){
        model.addAttribute("appointments",appointmentService.findAll());
        model.addAttribute("hospitalId", hospitalId);
        return "appointment/appointmentPage";
    }




















    @GetMapping("{appointmentId}/edit")
    public String edit(@PathVariable("appointmentId") Long appointmentId, Model model){
        model.addAttribute("appointment", appointmentService.findById(appointmentId));
        return "appointment/update";
    }
    @PostMapping("{id}/update")
    public String update(@ModelAttribute("appointment")Appointment appointment){
        appointmentService.update(appointment);
        return "redirect:/appointments";
    }

}
