
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.dto.ProjectTraineeDTO;
import co.id.library.project.LibraryServerApp.services.ProjectTraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("project/trainee")
public class ProjectTraineeController {
    @Autowired 
    ProjectTraineeService projectTraineeService;
    
    ProjectTraineeDTO projectTraineeDTO;
    
    @PostMapping("/trainee")
    public String createProjectTrainee (@RequestBody ProjectTraineeDTO projectTrainee){
        return projectTraineeService.registerProject(projectTrainee);
    }
}
