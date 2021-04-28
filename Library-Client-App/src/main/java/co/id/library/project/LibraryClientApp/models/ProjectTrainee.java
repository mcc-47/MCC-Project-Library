
package co.id.library.project.LibraryClientApp.models;

import java.util.List;
import lombok.Data;

@Data
public class ProjectTrainee {
    private Integer idProject;
    private String judul;
    private String deskripsi;
    private String erd;
    private String uml;
    private String skema;
    private String link;
    private Integer jumlahAnggota;
    private List<Integer> idMcc;

    public ProjectTrainee(Integer idProject, String judul, String deskripsi, String erd, 
            String uml, String skema, String link, Integer jumlahAnggota, List<Integer> idMcc) {
        this.idProject = idProject;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.erd = erd;
        this.uml = uml;
        this.skema = skema;
        this.link = link;
        this.jumlahAnggota = jumlahAnggota;
        this.idMcc = idMcc;
    }
    
    
}
