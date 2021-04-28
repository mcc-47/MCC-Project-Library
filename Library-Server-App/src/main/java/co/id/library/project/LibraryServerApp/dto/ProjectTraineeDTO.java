/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

import java.util.List;

public class ProjectTraineeDTO {
    
    private Integer idProject;
    private String judul;
    private String deskripsi;
    private String erd;
    private String uml;
    private String skema;
    private String link;
    private Integer jumlahAnggota;
    private List<Integer> idMcc;

    public ProjectTraineeDTO() {
    }

    public ProjectTraineeDTO(ProjectTraineeDTO projectTrainee) {
        this.idProject = projectTrainee.getIdProject();
        this.judul = projectTrainee.getJudul();
        this.deskripsi = projectTrainee.getDeskripsi();
        this.erd = projectTrainee.getErd();
        this.uml = projectTrainee.getUml();
        this.skema = projectTrainee.getSkema();
        this.link = projectTrainee.getLink();
        this.jumlahAnggota = projectTrainee.getJumlahAnggota();
        this.idMcc = projectTrainee.getIdMcc();
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getJumlahAnggota() {
        return jumlahAnggota;
    }

    public void setJumlahAnggota(Integer jumlahAnggota) {
        this.jumlahAnggota = jumlahAnggota;
    }

    public List<Integer> getIdMcc() {
        return idMcc;
    }

    public void setIdMcc(List<Integer> idMcc) {
        this.idMcc = idMcc;
    }
    
}
