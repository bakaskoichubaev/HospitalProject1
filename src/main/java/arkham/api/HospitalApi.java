package arkham.api;

import arkham.services.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalApi {

    private final HospitalService hospitalService;
}
