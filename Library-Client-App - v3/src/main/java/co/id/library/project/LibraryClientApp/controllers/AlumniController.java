/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.Trainee;
import co.id.library.project.LibraryClientApp.services.TraineeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ROG
 */
@Controller
@RequestMapping("/alumni")
public class AlumniController {
    
    @Autowired
    private TraineeService traineeService;
    
    //============DATA GET ALL ALUMNI==================
    @GetMapping
    public String getAlumni(Model model) {
        model.addAttribute("alumni", traineeService.getAlumni());
        return "admin/data-alumni";
    }
    
    @GetMapping("/get-alumni")
    public @ResponseBody List<Trainee> getAlumniProcess() {
        return traineeService.getAlumni();
    }
    //=====================================================
}
