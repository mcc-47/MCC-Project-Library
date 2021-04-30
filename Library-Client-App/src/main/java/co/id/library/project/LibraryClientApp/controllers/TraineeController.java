                
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
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("trainee", traineeService.getAll());
        return "admin/data-trainee";
    }
    
    //GET ALL
    @GetMapping("/get-all")
    public @ResponseBody List<Trainee> getAllProcess() {
        System.out.println("cetak trainee");
        return traineeService.getAll();
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
