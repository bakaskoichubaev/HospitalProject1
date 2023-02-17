package arkham.api;

import arkham.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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

}
