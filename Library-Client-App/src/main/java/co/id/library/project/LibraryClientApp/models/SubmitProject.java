/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryClientApp.models;

import java.util.List;
import lombok.Data;

@Data
public class SubmitProject {
    private Integer idProject;
    private String judul;
    //private List<Integer> idMcc;
    private Integer idMcc;
    private String deskripsi;

//    public SubmitProject(Integer idProject, String judul, List<Integer> idMcc, String deskripsi) {
//        this.idProject = idProject;
//        this.judul = judul;
//        this.idMcc = idMcc;
//        this.deskripsi = deskripsi;
//    }

    public SubmitProject() {
    }

    public SubmitProject(Integer idProject, String judul, Integer idMcc, String deskripsi) {
        this.idProject = idProject;
        this.judul = judul;
        this.idMcc = idMcc;
        this.deskripsi = deskripsi;
    }
    
    
    
}
