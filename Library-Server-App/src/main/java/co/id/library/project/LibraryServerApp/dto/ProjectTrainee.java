/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProjectTrainee {
    
//    private Integer idProject;
    private String judul;
    private String deskripsi;
//    private List<Integer> idMcc;
    private Integer idMccSatu;
    private Integer idMccDua;
    private Integer idMccTiga;

    public ProjectTrainee() {
    }

//    public ProjectTrainee(String judul, String deskripsi, List<Integer> idMcc) {
//        this.judul = judul;
//        this.deskripsi = deskripsi;
//        this.idMcc = idMcc;
//    }

//    public ProjectTrainee(Integer idProject, String judul, String deskripsi, Integer idMccSatu, Integer idMccDua, Integer idMccTiga) {
//        this.idProject = idProject;
//        this.judul = judul;
//        this.deskripsi = deskripsi;
//        this.idMccSatu = idMccSatu;
//        this.idMccDua = idMccDua;
//        this.idMccTiga = idMccTiga;
//    }

    public ProjectTrainee(String judul, String deskripsi, Integer idMccSatu, Integer idMccDua, Integer idMccTiga) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.idMccSatu = idMccSatu;
        this.idMccDua = idMccDua;
        this.idMccTiga = idMccTiga;
    }

//    public Integer getIdProject() {
//        return idProject;
//    }
//
//    public void setIdProject(Integer idProject) {
//        this.idProject = idProject;
//    }

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

//    public List<Integer> getIdMcc() {
//        return idMcc;
//    }
//
//    public void setIdMcc(List<Integer> idMcc) {
//        this.idMcc = idMcc;
//    }

    public Integer getIdMccSatu() {
        return idMccSatu;
    }

    public void setIdMccSatu(Integer idMccSatu) {
        this.idMccSatu = idMccSatu;
    }

    public Integer getIdMccDua() {
        return idMccDua;
    }

    public void setIdMccDua(Integer idMccDua) {
        this.idMccDua = idMccDua;
    }

    public Integer getIdMccTiga() {
        return idMccTiga;
    }

    public void setIdMccTiga(Integer idMccTiga) {
        this.idMccTiga = idMccTiga;
    }

    
    
}
