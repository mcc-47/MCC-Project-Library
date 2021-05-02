/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.ProjectTrainee;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Status;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import co.id.library.project.LibraryServerApp.repositories.TraineeRepository;
import java.sql.ResultSet;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProjectTraineeService {
    ProjectTrainee projectTrainee;
    
    Project project;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    TraineeRepository traineeRepository;
    
    @Autowired
    NotificationService notificationService;
        
//    public String registerProject (ProjectTrainee projectTrainee)throws MessagingException{
//        projectRepository.save(new Project(
//                projectTrainee.getIdProject(),
//                projectTrainee.getJudul(),
//                projectTrainee.getDeskripsi(),
//                projectTrainee.getErd(),
//                projectTrainee.getUml(),
//                projectTrainee.getSkema(),
//                projectTrainee.getLink(),
//                new Status(1)
//        ));
//        for( Integer anggota : projectTrainee.getIdMcc() ){
//            Trainee addProject = traineeRepository.findById(anggota).get();
//            addProject.setIdProject( new Project(projectTrainee.getIdProject()));
//            traineeRepository.save(addProject);
//        }        
//        Integer trainer = traineeRepository.findById(projectTrainee.getIdMcc().get(0)).get().getEmployee().getIdTrainer().getIdMcc();
//        notificationService.notifRegisJudul(trainer);
//        return "Registrasi Project Berhasil";
//    }
    
    public String registerJudul (ProjectTrainee projectTrainee)throws MessagingException{
        System.out.println(projectTrainee.getJudul());
        projectRepository.save(new Project(
                projectTrainee.getJudul(),
                projectTrainee.getDeskripsi(),
                new Status(1)
        ));
//        for( Integer anggota : projectTrainee.getIdMcc() ){
//            if(anggota != null){
//            Trainee addProject = traineeRepository.findById(anggota).get();
//                addProject.setIdProject( new Project(projectTrainee.getIdProject()));
////                Project project;
////                addProject.setIdProject( new Project(project.getIdProject()));
//                traineeRepository.save(addProject);
//            }
//        }        
//        Integer trainer = traineeRepository.findById(projectTrainee.getIdMcc().get(0)).get().getEmployee().getIdTrainer().getIdMcc();
        Trainee addProjectSatu = traineeRepository.findById(projectTrainee.getIdMccSatu()).get();
        addProjectSatu.setIdProject( new Project(projectRepository.findAll().get(projectRepository.findAll().size()-1).getIdProject()));
        traineeRepository.save(addProjectSatu);
        
        if(projectTrainee.getIdMccDua() != 0){
            Trainee addProjectDua = traineeRepository.findById(projectTrainee.getIdMccDua()).get();
            addProjectDua.setIdProject( new Project(projectRepository.findAll().get(projectRepository.findAll().size()-1).getIdProject()));
            traineeRepository.save(addProjectDua);
        }else{
           
        }
        
        if(projectTrainee.getIdMccTiga() != 0){
            Trainee addProjectTiga = traineeRepository.findById(projectTrainee.getIdMccTiga()).get();
            addProjectTiga.setIdProject( new Project(projectRepository.findAll().get(projectRepository.findAll().size()-1).getIdProject()));
            traineeRepository.save(addProjectTiga);
        }else{
            
        }
        Integer trainer = traineeRepository.findById(projectTrainee.getIdMccSatu()).get().getEmployee().getIdTrainer().getIdMcc();
        
        notificationService.notifRegisJudul(trainer);
        return "Registrasi Judul Berhasil";
    }
    
}
