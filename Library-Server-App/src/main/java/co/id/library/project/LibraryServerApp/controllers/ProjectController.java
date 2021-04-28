/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.services.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    
    //GET ALL
    @GetMapping("/get-all")
    public List<ProjectDTO> getProjectDTO(){
        return projectService.getProject();

    }
    
    //GET BY ID
    @GetMapping("{id}")
    public Project getOneProject(@PathVariable Integer id){
        return projectService.getById(id);
    }
    
    //UPDATE
    @PutMapping("{id}")
    public Project updateProject(@PathVariable Integer id, @RequestBody Project project){
        return projectService.update(id, project);
    }
    
    //DELETE
    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectService.create(project);
    }
}
