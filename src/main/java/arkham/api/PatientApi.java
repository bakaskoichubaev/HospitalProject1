package arkham.api;

import arkham.services.PatientService;
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
@RequestMapping("/patients")
public class PatientApi {

    private final PatientService patientService;

    @GetMapping
    public String getAllPatients(Model model){
        model.addAttribute("patients", patientService.findAll());
        return "patient/patientPage";
    }
}
