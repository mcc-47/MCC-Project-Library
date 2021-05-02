
package co.id.library.project.LibraryClientApp.models;

import java.util.List;
import lombok.Data;

@Data
public class SearchProject {
    private Integer idProject;
    private String judul;
    private String batch;
    private List<String> nama;
    private String trainer;
    private String deskripsi;
    private String skema;
    private String link;

    public SearchProject(Integer idProject, String judul, String batch, List<String> nama, 
            String trainer, String deskripsi, String skema, String link) {
        this.idProject = idProject;
        this.judul = judul;
        this.batch = batch;
        this.nama = nama;
        this.trainer = trainer;
        this.deskripsi = deskripsi;
        this.skema = skema;
        this.link = link;
    }

    public SearchProject() {
    }
   
  
    
    
}