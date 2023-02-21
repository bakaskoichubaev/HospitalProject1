package arkham.api;

import arkham.models.Department;
import arkham.models.Doctor;
import arkham.services.DepartmentService;
import arkham.services.DoctorService;
import arkham.services.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentApi {

    private final DepartmentService departmentService;
    private final HospitalService hospitalService;
    private final DoctorService doctorService;


    @GetMapping("/{id}")
    public String getAllDepartments(Model model,
                                    @PathVariable("id") Long id ,
                                    @ModelAttribute("doctor") Doctor doctor ){
        model.addAttribute("departments", departmentService.findAll(id));
        model.addAttribute("doctors", doctorService.getAllDoctors(id));
        model.addAttribute("hospitalId",id);
        return "department/departments";
    }






    @PostMapping("/save/{departmentId}")
    public String save(@ModelAttribute("newDepartment") Department department,
                       @PathVariable Long departmentId) {
        departmentService.save(departmentId, department);
        return "redirect:/departments/"+departmentId;
    }

    @GetMapping("/new/{id}")
    public String create(Model model,
                         @PathVariable("id")Long id) {
        model.addAttribute("newDepartment", new Department());
        model.addAttribute("hospitalId", id);
        return "/department/saveDepartment";
    }









    @PostMapping("{hospitalId}/{departmentId}/assignDoctor")
    private String assignDoctor(@PathVariable("hospitalId") Long hospitalId,
                               @PathVariable("departmentId") Long departmentId,
                               @ModelAttribute("doctor") Doctor doctor)
            throws IOException {
        System.out.println(doctor);
        Long id = doctor.getId();
        doctorService.assignDoctor(departmentId, id);
        return "redirect:/departments/" + hospitalId;
    }










//    @GetMapping("{departmentId}/edit")
//    public String edit(@PathVariable("departmentId") Long departmentId, Model model, @PathVariable Long id) {
//        model.addAttribute("department", departmentService.findById(departmentId));
//        model.addAttribute("hospitalId",id);
//        return "/department/update";
//    }
//
//    @PostMapping("/{id}/update")
//    public String update(@ModelAttribute("department") Department department) {
//        departmentService.update(department);
//        return "redirect:/{id}/departments";
//    }


}
