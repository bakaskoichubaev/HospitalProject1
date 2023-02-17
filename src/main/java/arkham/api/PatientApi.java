package arkham.api;

import arkham.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
}
