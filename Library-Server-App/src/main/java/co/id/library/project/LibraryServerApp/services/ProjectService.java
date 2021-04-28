/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProjectService {
    
    @Autowired
    ProjectRepository projectRepository;
    
    ProjectDTO projectDTO;
    
    public List<ProjectDTO> getProject() {
        List<Project> project = projectRepository.findAll();
        List<ProjectDTO> pdds = new ArrayList<>();
        for (Project p : project) {
            ProjectDTO td = new ProjectDTO(
                    p.getIdProject(),
                    p.getJudul(),
                    p.getDeskripsi(),
                    p.getErd(),
                    p.getUml(),
                    p.getSkema(),
                    p.getLink(),
                    p.getTraineeList(),
                    p.getTraineeList().get(0).getEmployee().getIdTrainer().getIdMcc());
            pdds.add(td);
        }
        
        return pdds;
    }
    
    public Project getById(Integer idProject){
        return projectRepository.findById(idProject).get();
    }
    
    public Project create(Project project){
        return projectRepository.save(project);
    }
    
    public Project update (Integer id, Project project){
        Project updateProject = projectRepository.findById(id).get();
        updateProject.setJudul(project.getJudul());
        updateProject.setDeskripsi(project.getDeskripsi());
        updateProject.setErd(project.getErd());
        updateProject.setUml(project.getUml());
        updateProject.setSkema(project.getSkema());
        updateProject.setLink(project.getLink());
        updateProject.setCurrentStatus(project.getCurrentStatus());
        return projectRepository.save(updateProject);
    }
    
}
