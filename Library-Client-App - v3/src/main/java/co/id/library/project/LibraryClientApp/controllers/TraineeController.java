                
package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.Trainee;
import co.id.library.project.LibraryClientApp.services.TraineeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/trainee")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;
    
    //============DATA GET ALL TRAINEE==================
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("trainee", traineeService.getAll());
        return "admin/data-trainee";
    }
    
    @GetMapping("/get-all")
    public @ResponseBody List<Trainee> getAllProcess() {
        return traineeService.getAll();
    }
    //===============================================
    
     //============DATA GET ALL ALUMNI==================
    @GetMapping("/alumni")
    public String getAlumni(Model model) {
        model.addAttribute("alumni", traineeService.getAlumni());
        return "admin/data-alumni";
    }
    
    @GetMapping("/get-alumni")
    public @ResponseBody List<Trainee> getAlumniProcess() {
        return traineeService.getAlumni();
    }
    //===============================================
    
    //GET HISTORY PROJECT
    @GetMapping("/project-history")
    public String getProjectHistory(Model model) {
        model.addAttribute("trainee", traineeService.getAll());
        return "trainee/trainee-project-history";
    }
    
    //GET BY ID
    @GetMapping("/{id}")
    public @ResponseBody Trainee getById(@PathVariable("id") Integer id) {
        return traineeService.getById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id, @RequestBody Trainee trainee) {
        System.out.println(trainee);
        return traineeService.update(id, trainee);

    }
    
    //DELETE
    @DeleteMapping("/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        System.out.println("trainee");
        return traineeService.delete(id);
    }
}
