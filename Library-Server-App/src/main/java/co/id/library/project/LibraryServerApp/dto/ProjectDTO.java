
package co.id.library.project.LibraryServerApp.dto;

import co.id.library.project.LibraryServerApp.entities.Trainee;
import java.util.List;

public class ProjectDTO {
    private Integer idProject;
    private String judul;
    private String deskripsi;
    private String linkProject;
    private String trainee;
    private String trainer;

    public ProjectDTO(Integer idProject, String judul, String deskripsi, String linkProject, String trainee, String trainer) {
        this.idProject = idProject;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.linkProject = linkProject;
        this.trainee = trainee;
        this.trainer = trainer;
    }

    public ProjectDTO(Integer idProject, String judul, String deskripsi, String link, List<Trainee> traineeList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLinkProject() {
        return linkProject;
    }

    public void setLinkProject(String linkProject) {
        this.linkProject = linkProject;
    }

    public String getTrainee() {
        return trainee;
    }

    public void setTrainee(String trainee) {
        this.trainee = trainee;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
    
    
}
