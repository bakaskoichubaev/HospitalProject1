package arkham.api;

import arkham.models.Department;
import arkham.models.Patient;
import arkham.models.enums.Gender;
import arkham.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
        return "redirect:/patients/" + hospitalId;
    }
    @GetMapping("/new/{id}")
    public String create(Model model,
                         @PathVariable("id") Long id){
        model.addAttribute("newPatient", new Patient());
        model.addAttribute("hospitalId",id);
        model.addAttribute("male", Gender.MALE);
        model.addAttribute("female", Gender.FEMALE);
        return "/patient/savePatient";
    }














    @GetMapping("/edit/{patientId}")
    public String edit(@PathVariable("patientId")Long patientId,
                       Model model){
        Patient patient = patientService.findById(patientId);
        model.addAttribute("patient", patient);
        model.addAttribute("hospitalId",patient.getHospital().getId());
        model.addAttribute("male", Gender.MALE);
        model.addAttribute("female", Gender.FEMALE);
        return "/patient/update";
    }

    @PostMapping("/{hospitalId}/{patientId}/update")
    public String update(@ModelAttribute("patient") Patient patient,
                         @PathVariable("patientId") Long patientId,
                         @PathVariable("hospitalId") Long hospitalId){
        patientService.update(patientId,patient);
        return "redirect:/patients/" + hospitalId;
    }




    @GetMapping("/{hospitalId}/{patientId}/delete")
    public String deletePatient(@PathVariable("patientId")Long id,
                                @PathVariable("hospitalId")Long hospitalId){
        patientService.deletePatient(id);
        return"redirect:/patients/" + hospitalId;
    }

}
