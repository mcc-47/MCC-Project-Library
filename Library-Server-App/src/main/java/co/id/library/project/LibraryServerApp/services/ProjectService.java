/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import java.util.Optional;
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
