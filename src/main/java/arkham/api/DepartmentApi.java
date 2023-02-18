package arkham.api;

import arkham.models.Department;
import arkham.models.Hospital;
import arkham.services.DepartmentService;
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
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentApi {

    private final DepartmentService departmentService;
    private final HospitalService hospitalService;

    @GetMapping
    public String getAllDepartments(Model model){
        model.addAttribute("departments",departmentService.findAll());
        return "department/departmentPage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("newDepartment")Department department,
                         @RequestParam("hospitalId") Long id){
        departmentService.save(id, department);
        return "redirect:/departments";
    }

    @GetMapping("/new")
    public String creat(Model model){
        model.addAttribute("newDepartment", new Department());
        model.addAttribute("hospitals", hospitalService.findAll());
        return "department/newDepartment";
    }


//    @GetMapping("/new")
//    public String create(Model model){
//        model.addAttribute("newHospital", new Hospital());
//        return "hospital/newHospital";
//    }
//
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute("newCompany") Hospital hospital){
//        hospitalService.save(hospital);
//        return "redirect:/hospitals";
//    }

}
