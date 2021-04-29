/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.Project;
import co.id.library.project.LibraryClientApp.models.ProjectTrainee;
import co.id.library.project.LibraryClientApp.services.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("project", projectService.getAll());
        return "trainee/search-project";
    }
    
    //GET ALL
    @GetMapping("/get-all")
    public @ResponseBody List<Project> getAllProcess() {
        return projectService.getAll();
    }

    //GET BY ID
    @GetMapping("/{id}")
    public @ResponseBody
    Project getById(@PathVariable("id") Integer id) {
        return projectService.getById(id);
    }

    //CREATE PROJECT
    @PostMapping
    public @ResponseBody String create(@RequestBody Project project) {
        System.out.println(project);
        return projectService.create(project);
    }
    
     //CREATE PROJECT TRAINEE
    @PostMapping("/trainee")
    public @ResponseBody String createProjectTrainee(@RequestBody ProjectTrainee projectTrainee) {
        System.out.println(projectTrainee);
        return projectService.createProjectTrainee(projectTrainee);
    }

    //UPDATE PROJECT
    @PutMapping("/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id, @RequestBody Project project) {
        System.out.println(project);
        return projectService.update(id, project);

    }
    
    //UPDATE JUDUL
    @PutMapping("/update-judul/{id}")
    public @ResponseBody String updateJudul(@PathVariable("id") Integer id, String judul, String deskripsi) {
        return projectService.updateJudul(id, judul, deskripsi);

    }
    
    //UPDATE LINK
    @PutMapping("/update-link/{id}")
    public @ResponseBody String updateLink(@PathVariable("id") Integer id, String erd, String uml, String skema, String link) {
        return projectService.updateLink(id, erd, uml, skema, link);

    }

}
