/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

/**
 *
 * @author ASUS
 */
public class ProjectTraineeDTO {
    private Integer idProject;
    private String judul;
    private String deskripsi;
    private String erd;
    private String uml;
    private String skema;
    private String link;
    private String currentStatus;
    private Integer idSatu;
    private Integer idDua;
    private Integer idTiga;

    public ProjectTraineeDTO(Integer idProject, String judul, String deskripsi, String erd, String uml, String skema, 
            String link, String currentStatus, Integer idSatu, Integer idDua, Integer idTiga) {
        this.idProject = idProject;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.erd = erd;
        this.uml = uml;
        this.skema = skema;
        this.link = link;
        this.currentStatus = currentStatus;
        this.idSatu = idSatu;
        this.idDua = idDua;
        this.idTiga = idTiga;
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

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getIdSatu() {
        return idSatu;
    }

    public void setIdSatu(Integer idSatu) {
        this.idSatu = idSatu;
    }

    public Integer getIdDua() {
        return idDua;
    }

    public void setIdDua(Integer idDua) {
        this.idDua = idDua;
    }

    public Integer getIdTiga() {
        return idTiga;
    }

    public void setIdTiga(Integer idTiga) {
        this.idTiga = idTiga;
    }
    
    
    
    
}
