/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.dto.ProjectTrainee;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.services.NotificationService;
import co.id.library.project.LibraryServerApp.services.ProjectService;
import co.id.library.project.LibraryServerApp.services.ProjectTraineeService;
import java.util.List;
import javax.mail.MessagingException;
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
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
    ProjectTraineeService projectTraineeService;
    
    @Autowired
    NotificationService notificationService;
            
    @GetMapping("/get-all")
    public List<ProjectDTO> getProjectDTO(){
        return projectService.getProject();
    }
    
    @GetMapping("{id}")
    public Project getOneProject(@PathVariable Integer id){
        return projectService.getById(id);
    }
    
    @PutMapping("{id}")
    public Project updateProject(@PathVariable Integer id, @RequestBody Project project){
        return projectService.update(id, project);
    }
    
    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectService.create(project);
    }
    
    @PostMapping("/trainee")
    public String createProjectTrainee (@RequestBody ProjectTrainee projectTrainee)throws MessagingException{
        return projectTraineeService.registerProject(projectTrainee);
    }
}
