package arkham.api;

import arkham.models.Patient;
import arkham.models.enums.Gender;
import arkham.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller

@RequestMapping("/patients")
public class PatientApi {

    private final PatientService patientService;

    @Autowired
    public PatientApi(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping("/{id}")
    public String getAllPatients(Model model, @PathVariable Long id) {
        model.addAttribute("patients", patientService.findAll(id));
        model.addAttribute("hospitalId", id);
        return "patient/patientPage";
    }


    @PostMapping("/save/{hospitalId}")
    public String save(@ModelAttribute("newPatient") Patient patient,
                       @PathVariable Long hospitalId){
        patientService.save(hospitalId, patient);
        return "redirect:/doctors/" + hospitalId;
    }


    @GetMapping("/new/{id}")
    public String create(Model model,
                         @PathVariable Long id){
        model.addAttribute("patient", new Patient());
        model.addAttribute("hospitalId", id);
        model.addAttribute("male", Gender.MALE);
        model.addAttribute("female", Gender.FEMALE);
        return "patient/savePatient";
    }


















//    @GetMapping("{patientId}/edit")
//    public String edit(@PathVariable("patientId")Long patientId, Model model){
//        model.addAttribute("patient", patientService.findById(patientId));
//        return "patient/update";
//    }
//    @PostMapping("{id}/update")
//    public String update(@ModelAttribute("patient") Patient patient){
//        patientService.update(patient);
//        return "redirect:/patients";
//    }
}
