package arkham.api;

import arkham.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorApi{

    private final DoctorService doctorService;

    @GetMapping
    public String getAllDoctors(Model model){
        model.addAttribute("doctors",doctorService.getAllDoctors());
        return "doctor/doctorPage";
    }
}
