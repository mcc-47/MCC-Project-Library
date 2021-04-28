
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    
    ProjectDTO projectDTO;
    
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    //GET ALL
    public List<ProjectDTO> getProject() {
        List<Project> project = projectRepository.findAll();
        List<ProjectDTO> pdds = new ArrayList<>();
        for (Project p : project) {
            
            ProjectDTO td = new ProjectDTO(
                    p.getIdProject(),
                    p.getJudul(),
                    p.getDeskripsi(),
                    p.getLink(),
                    p.getTraineeList());
            pdds.add(td);
        }
        
        return pdds;
    }
    
    //GET BY ID
    public Project getById(Integer idProject){
        return projectRepository.findById(idProject).get();
    }
    
    //CREATE
    public Project create(Project project){
        return projectRepository.save(project);
    }
    
    //UPDATE
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
