
package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.Trainer;
import co.id.library.project.LibraryClientApp.services.TrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;
    
    @GetMapping
    public String getAllTrainer(Model model) {
        model.addAttribute("trainer", trainerService.getAll());
        return "admin/data-trainer";
    }
  
    //GET ALL
    @GetMapping("/get-all")
    public @ResponseBody List<Trainer> getAllProcess() {
        return trainerService.getAll();
    }
    
    //GET BY ID
    @GetMapping("/{id}")
    public @ResponseBody Trainer getById(@PathVariable("id") Integer id) {
        return trainerService.getById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id, @RequestBody Trainer trainer) {
        System.out.println(trainer);
        return trainerService.update(id, trainer);

    }
    
    //DELETE
    @DeleteMapping("/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        System.out.println("trainer");
        return trainerService.delete(id);
    }
}
