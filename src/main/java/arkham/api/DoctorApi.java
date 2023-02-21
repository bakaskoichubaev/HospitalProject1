package arkham.api;

import arkham.models.Department;
import arkham.models.Doctor;
import arkham.services.DoctorService;
import arkham.services.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorApi{

    private final DoctorService doctorService;

    private final HospitalService hospitalService;


    @GetMapping("/{id}")
    public String getAllDoctors(Model model, @PathVariable Long id){
        model.addAttribute("doctors",doctorService.getAllDoctors(id));
        model.addAttribute("hospitalId", id);
        return "/doctor/doctorPage";
    }

    @PostMapping("/save/{hospitalId}")
    public String save(@ModelAttribute("newDoctor")Doctor doctor,
                       @PathVariable Long hospitalId){
        doctorService.save(hospitalId, doctor);
        return "redirect:/doctors/" + hospitalId;
    }

    @GetMapping("/new/{id}")
    public String create(Model model,
                         @PathVariable("id") Long id){
        model.addAttribute("newDoctor", new Doctor());
        model.addAttribute("hospitalId", id);
        return "/doctor/saveDoctor";
    }





//    @GetMapping("{doctorId}/edit")
//    public String edit(@PathVariable("doctorId")Long doctorId, Model model, @PathVariable Long id){
//        model.addAttribute("doctor", doctorService.findById(doctorId));
//        model.addAttribute("hospitalId", id);
//        return "doctor/update";
//    }
//    @PostMapping("{id}/update")
//    public String update(@ModelAttribute("doctor")Doctor doctor){
//        doctorService.update(doctor);
//        return "redirect:/{id}/doctors";
//    }


}
