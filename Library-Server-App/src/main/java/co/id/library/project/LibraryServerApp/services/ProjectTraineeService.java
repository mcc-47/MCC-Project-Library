/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.ProjectTraineeDTO;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Status;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import co.id.library.project.LibraryServerApp.repositories.TraineeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectTraineeService {
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    TraineeRepository traineeRepository;
    
    ProjectTraineeDTO projectTraineeDTO;
    
    public Project create(Project project){
        return projectRepository.save(project);
    }
    
    public String registerProject (ProjectTraineeDTO projectTraineeDTO){
        List<Trainee> trainee = new ArrayList<>();
        projectRepository.save(new Project(
                projectTraineeDTO.getIdProject(),
                projectTraineeDTO.getJudul(),
                projectTraineeDTO.getDeskripsi(),
                projectTraineeDTO.getErd(),
                projectTraineeDTO.getUml(),
                projectTraineeDTO.getSkema(),
                projectTraineeDTO.getLink(),
                new Status(1,"proses")
        ));
        //Trainee addProject = traineeRepository.findById(projectTrainee.getIdSatu()).get();
//        traineeRepository.save(addProject.setIdPro(projectTrainee.getIdProject()));
        
        return "Registrasi Project Berhasil";
    }
    
//    public Trainee update (Integer id, Trainee trainee){
//        Trainee updateTrainee = traineeRepository.findById(id).get();
//    }
    
//    public Project update (Integer id, Project project){
//        Project updateProject = projectRepository.findById(id).get();
//        updateProject.setJudul(project.getJudul());
//        updateProject.setDeskripsi(project.getDeskripsi());
//        updateProject.setErd(project.getErd());
//        updateProject.setUml(project.getUml());
//        updateProject.setSkema(project.getSkema());
//        updateProject.setLink(project.getLink());
//        updateProject.setCurrentStatus(project.getCurrentStatus());
//        return projectRepository.save(updateProject);
//    }
}
