/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.GetJudulDTO;
import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.dto.ProjectTrainee;
import co.id.library.project.LibraryServerApp.dto.SearchTraineeDTO;
import co.id.library.project.LibraryServerApp.entities.History;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Status;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import co.id.library.project.LibraryServerApp.repositories.HistoryRepository;
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
    
    @Autowired
    HistoryRepository historyRepository;
    
    ProjectDTO projectDTO;
    SearchTraineeDTO searchTraineeDTO;
    ProjectTrainee projectTrainee;
    
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
    
    public List<SearchTraineeDTO> getSearchProject() {
        List<Project> project = projectRepository.findAll();
        List<SearchTraineeDTO> pdds = new ArrayList<>();
        for (Project p : project) {
            List<String> nama = new ArrayList<>();
            for (Trainee t : p.getTraineeList()) {
                nama.add(t.getEmployee().getNama());
            }
            SearchTraineeDTO td = new SearchTraineeDTO(
                    p.getIdProject(),
                    p.getJudul(),
                    p.getTraineeList().get(0).getBatch(),
                    nama,
                    p.getTraineeList().get(0).getEmployee().getIdTrainer().getNama(),
                    p.getDeskripsi(),
                    p.getSkema(),
                    p.getLink()
            );
            pdds.add(td);
        }

        return pdds;
    }
    
    public List<GetJudulDTO> getAllJudul(){
//        Integer idProject = employeeRepository.findById(idMcc).get().getTrainee().getIdProject().getIdProject();
//        Project e = projectRepository.findById(idProject).get();
        List<Project> project = projectRepository.findAll();
        List<GetJudulDTO> pdds = new ArrayList<>();
        for (Project e : project) {
            List<String> nama = new ArrayList<>();
                for (Trainee t : e.getTraineeList()){
                    nama.add(t.getEmployee().getNama());
                }
            GetJudulDTO td = new GetJudulDTO(
                            e.getIdProject(),
                            e.getJudul(),
                            e.getTraineeList().get(0).getBatch(),
                            nama,
                            e.getTraineeList().get(0).getEmployee().getIdTrainer().getNama(),
                            e.getDeskripsi()
                    );
            pdds.add(td);
        }
        return pdds;
    }
    
    public Project getById(Integer idProject){
        return projectRepository.findById(idProject).get();
    }
    
    public GetJudulDTO getByIdMcc(Integer idMcc){
        Integer idProject = employeeRepository.findById(idMcc).get().getTrainee().getIdProject().getIdProject();
        Project e = projectRepository.findById(idProject).get();
        List<String> nama = new ArrayList<>();
            for (Trainee t : e.getTraineeList()){
                nama.add(t.getEmployee().getNama());
            }
        GetJudulDTO td = new GetJudulDTO(
                        e.getIdProject(),
                        e.getJudul(),
                        e.getTraineeList().get(0).getBatch(),
                        nama,
                        e.getTraineeList().get(0).getEmployee().getIdTrainer().getNama(),
                        e.getDeskripsi()
                );
        return td;
    }
    
    public ProjectDTO getProjectByIdMcc(Integer idMcc){
        Integer idProject = employeeRepository.findById(idMcc).get().getTrainee().getIdProject().getIdProject();
        Project p = projectRepository.findById(idProject).get();
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
        return td;
    }
    
//    public ProjectDTO getProjectByIdTrainer(Integer idMcc){
//        Integer idProject = employeeRepository.findById(idMcc).get().getEmployeeList().get(0).getTrainee().getIdProject().getIdProject();
//        Project p = projectRepository.findById(idProject).get();
//        List<String> nama = new ArrayList<>();
//            for (Trainee t : p.getTraineeList()){
//                nama.add(t.getEmployee().getNama());
//            }
//        ProjectDTO td = new ProjectDTO(
//                    p.getIdProject(),
//                    p.getJudul(),
//                    p.getDeskripsi(),
//                    p.getErd(),
//                    p.getUml(),
//                    p.getSkema(),
//                    p.getLink(),
//                    nama,
//                    p.getTraineeList().get(0).getEmployee().getIdTrainer().getNama());
//        return td;
//    }
    
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
        
        historyRepository.save(new History(
                "status_judul",
                java.util.Calendar.getInstance().getTime(),
                new Project(id),
                new Status(1)
        ));
        
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
        
        historyRepository.save(new History(
                "status_link",
                java.util.Calendar.getInstance().getTime(),
                new Project(id),
                new Status(1)
        ));
        
        return projectRepository.save(updateProject);
    }
    
    public Project updateStatusJudul (Integer id, boolean status, String pesan)throws MessagingException{
        Project updateProject = projectRepository.findById(id).get();
        if(status == true){
            updateProject.setCurrentStatus(new Status(4));
            for (Trainee t : updateProject.getTraineeList()){
                Integer trainee =t.getEmployee().getIdMcc();
                notificationService.notifValidasiDiterima(trainee);
            }
            historyRepository.save(new History(
                "status_judul",
                java.util.Calendar.getInstance().getTime(),
                pesan,
                new Project(id),
                new Status(3)
            ));
            historyRepository.save(new History(
                "status_project",
                java.util.Calendar.getInstance().getTime(),
                "mulai mengerjakan project",
                new Project(id),
                new Status(4)
            ));
        }
        else{
            updateProject.setCurrentStatus(new Status(2));
            for (Trainee t : updateProject.getTraineeList()){
                Integer trainee =t.getEmployee().getIdMcc();
                notificationService.notifValidasiDitolak(trainee);
            }
            historyRepository.save(new History(
                "status_judul",
                java.util.Calendar.getInstance().getTime(),
                pesan,
                new Project(id),
                new Status(2)
            ));
        }
        
        return projectRepository.save(updateProject);
    }
    
    public Project updateStatusLink (Integer id, boolean status, String pesan)throws MessagingException{
        Project updateProject = projectRepository.findById(id).get();
        if(status == true){
            updateProject.setCurrentStatus(new Status(5));
            for (Trainee t : updateProject.getTraineeList()){
                Integer trainee =t.getEmployee().getIdMcc();
                traineeRepository.findById(trainee).get().setStatusMcc("lulus");
                notificationService.notifValidasiDiterima(trainee);
            }
            historyRepository.save(new History(
                "status_link",
                java.util.Calendar.getInstance().getTime(),
                pesan,
                new Project(id),
                new Status(3)
            ));
            historyRepository.save(new History(
                "status_project",
                java.util.Calendar.getInstance().getTime(),
                "project telah selesai dilaksanakan",
                new Project(id),
                new Status(5)
            ));
        }
        else{
            updateProject.setCurrentStatus(new Status(2));
            for (Trainee t : updateProject.getTraineeList()){
                Integer trainee =t.getEmployee().getIdMcc();
                notificationService.notifValidasiDitolak(trainee);
            }
            historyRepository.save(new History(
                "status_link",
                java.util.Calendar.getInstance().getTime(),
                pesan,
                new Project(id),
                new Status(2)
            ));
        }
        
        return projectRepository.save(updateProject);
    }
    
}
