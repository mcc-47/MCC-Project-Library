
package co.id.library.project.LibraryClientApp.models;

import java.util.List;
import lombok.Data;


@Data
public class Project {
   private Integer idProject;
    private String judul;
    private String deskripsi;
    private String erd;
    private String uml;
    private String skema;
    private String link;
    private List<Trainee> trainee;
    private Integer trainer;

    public Project(Integer idProject, String judul, String deskripsi, String erd, String uml, 
            String skema, String link, List<Trainee> trainee, Integer trainer) {
        this.idProject = idProject;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.erd = erd;
        this.uml = uml;
        this.skema = skema;
        this.link = link;
        this.trainee = trainee;
        this.trainer = trainer;
    }
    
}
