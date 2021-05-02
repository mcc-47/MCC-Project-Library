/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

import co.id.library.project.LibraryServerApp.entities.Trainee;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProjectDTO {
    private Integer idProject;
    private String judul;
    private String deskripsi;
    private String erd;
    private String uml;
    private String skema;
    private String link;
    private List<Trainee> trainee;
    private List<String> nama;
    private String trainer;

    public ProjectDTO(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    public ProjectDTO(Integer idProject, String judul, String deskripsi, String erd, String uml, String skema, String link, List<String> nama, String trainer) {
        this.idProject = idProject;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.erd = erd;
        this.uml = uml;
        this.skema = skema;
        this.link = link;
        this.nama = nama;
        this.trainer = trainer;
    }

    public List<String> getNama() {
        return nama;
    }

    public void setNama(List<String> nama) {
        this.nama = nama;
    }

    

    public ProjectDTO() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Trainee> getTrainee() {
        return trainee;
    }

    public void setTrainee(List<Trainee> trainee) {
        this.trainee = trainee;
    }


    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getErd() {
        return erd;
    }

    public void setErd(String erd) {
        this.erd = erd;
    }

    public String getUml() {
        return uml;
    }

    public void setUml(String uml) {
        this.uml = uml;
    }

    public String getSkema() {
        return skema;
    }

    public void setSkema(String skema) {
        this.skema = skema;
    }
    
    

    
    
}
