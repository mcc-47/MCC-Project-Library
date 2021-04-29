/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Status;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import co.id.library.project.LibraryServerApp.repositories.TraineeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
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
    
    @Autowired
    TraineeRepository traineeRepository;
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    ProjectDTO projectDTO;
    
    public List<ProjectDTO> getProject() {
        List<Project> project = projectRepository.findAll();
        List<ProjectDTO> pdds = new ArrayList<>();
        for (Project p : project) {
            List<String> nama = new ArrayList<>();
            for (Trainee t : p.getTraineeList()){
                nama.add(t.getEmployee().getNama());
            }
            ProjectDTO td = new ProjectDTO(
                    p.getIdProject(),
                    p.getJudul(),
                    p.getDeskripsi(),
                    p.getErd(),
                    p.getUml(),
                    p.getSkema(),
                    p.getLink(),
                    nama,
                    p.getTraineeList().get(0).getEmployee().getIdTrainer().getNama());
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
    
    public Project update (Integer id, Project project)throws MessagingException{
        Project updateProject = projectRepository.findById(id).get();
        updateProject.setJudul(project.getJudul());
        updateProject.setDeskripsi(project.getDeskripsi());
        updateProject.setErd(project.getErd());
        updateProject.setUml(project.getUml());
        updateProject.setSkema(project.getSkema());
        updateProject.setLink(project.getLink());
        updateProject.setCurrentStatus(new Status(1));
        
        Integer trainer = updateProject.getTraineeList().get(0).getEmployee().getIdTrainer().getIdMcc();
        notificationService.notifUpdateProject(trainer);
        
        return projectRepository.save(updateProject);
    }
    
    public Project updateJudul (Integer id, String judul, String deskripsi)throws MessagingException{
        Project updateProject = projectRepository.findById(id).get();
        updateProject.setJudul(judul);
        updateProject.setDeskripsi(deskripsi);
        updateProject.setCurrentStatus(new Status(1));
        
        Integer trainer = updateProject.getTraineeList().get(0).getEmployee().getIdTrainer().getIdMcc();
        notificationService.notifUpdateJudul(trainer);
        
        return projectRepository.save(updateProject);
    }
    
    public Project updateLink (Integer id, String erd, String uml, String skema, String link)throws MessagingException{
        Project updateProject = projectRepository.findById(id).get();
        updateProject.setErd(erd);
        updateProject.setUml(uml);
        updateProject.setSkema(skema);
        updateProject.setLink(link);
        updateProject.setCurrentStatus(new Status(1));
        
        Integer trainer = updateProject.getTraineeList().get(0).getEmployee().getIdTrainer().getIdMcc();
        notificationService.notifUpdateLink(trainer);
        
        return projectRepository.save(updateProject);
    }
    
}
